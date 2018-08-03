package com.zlsoft.portal.web.rest;

import com.google.common.base.Strings;
import com.zlsoft.common.CommonConstants;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.service.OrderService;
import com.zlsoft.common.web.vm.MemberVM;
import com.zlsoft.domain.Invoice;
import com.zlsoft.domain.Order;
import com.zlsoft.portal.Constants;
import com.zlsoft.security.SecurityUtils;
import com.zlsoft.utils.WxPayUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderResource {

    @Inject
    private MemberService memberService;

    @Inject
    private OrderService orderService;

    /**
     * GET  /page/{page} : get payment data by page
     * @param session the HTTP Session
     * @param page zero-based page index
     * @return payment data by page
     */
    @GetMapping("/page/{page}")
    public ResponseEntity getPayments(HttpSession session, @PathVariable("page") int page){

        MemberVM member = this.getCurrentUser(session);

        if(member == null) {
            return ResponseEntity.badRequest().build();
        }

        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);

        Page<Order> payments = this.orderService.findByMemberId(member.getId(), pageRequest);

        return ResponseEntity.ok(payments);
    }

    /**
     * POST  /pay/type : choose the pay type
     * @param payment payment information
     * @return HTTP Status with payment information
     */
    @PostMapping("/pay/type")
    public ResponseEntity ChoosePay(Order payment) {
        payment = this.orderService.save(payment);
        return ResponseEntity.ok(payment);
    }

    /**
     * POST  /pay/type : pay the order
     * @param payment payment information
     * @return HTTP Status with payment information
     */
    @PostMapping("/pay")
    public ResponseEntity Pay(Order payment) {
        payment = this.orderService.save(payment);
        return ResponseEntity.ok(payment);
    }

    /**
     * GET  /dues : get the member's dues
     * @return dues
     */
    @GetMapping("/dues")
    public ResponseEntity getDues() {
        double price = 100.00d;
        return ResponseEntity.ok(price);
    }

    /**
     * GET  /duration : get the duration
     * @return duration
     */
    @GetMapping("/duration")
    public ResponseEntity getDuration() {
        int duration = 4;
        return ResponseEntity.ok(duration);
    }

    /**
     * POST  /order : create order
     * @param order payment information
     * @param invoice invoice information
     * @return HTTP Status with payment information
     */
    @PostMapping("/order")
    public ResponseEntity order(Order order, Invoice invoice) {

        if(Strings.isNullOrEmpty(order.getOrderNo())) {
            order.setOrderNo(WxPayUtil.generateOutTradeNo());
        }

        order = this.orderService.save(order, invoice);

        return ResponseEntity.ok(order);
    }

    private MemberVM getCurrentUser(HttpSession session) {

        Object sessionInfo = session.getAttribute(CommonConstants.SESSION_USER);

        if(sessionInfo != null) {
            return (MemberVM) sessionInfo;
        } else {
            Optional<String> username = SecurityUtils.getCurrentUserLogin();

            if(username.isPresent()) {
                MemberVM member = this.memberService.findByLogin(username.get());
                session.setAttribute(CommonConstants.SESSION_USER, member);
                return member;
            } else {
                return null;
            }
        }
    }
}
