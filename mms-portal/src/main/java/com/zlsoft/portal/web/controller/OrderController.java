package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.OrderService;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.common.web.vm.MemberVM;
import com.zlsoft.domain.Invoice;
import com.zlsoft.domain.Order;
import com.zlsoft.portal.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/payment")
public class OrderController extends BaseController {

    @Inject
    private OrderService orderService;

    /**
     * GET  /payment : get payment page
     * @return payment page
     */
    @GetMapping
    public String payment() {
        return "/member/personal_payment";
    }

    /**
     * GET  /page/{page} : get payment data by page
     * @param session the HTTP Session
     * @param page zero-based page index
     * @return payment data by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity getPayments(HttpSession session, @PathVariable("page") int page){

        MemberVM member = this.getCurrentUser(session);

        if(member == null) {
            return ResponseEntity.badRequest().build();
        }

        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);

        Page<Order> payments = this.orderService.findByMemberId(member.getId(), pageRequest);

        return ResponseEntity.ok(payments);
    }

    /**
     * GET  /pay : get pay page
     * @return pay page
     */
    @GetMapping("/pay")
    public String pay() {
        return "/member/personal_pay";
    }

    /**
     * POST  /pay/type : choose the pay type
     * @param payment payment information
     * @return HTTP Status with payment information
     */
    @PostMapping("/pay/type")
    public @ResponseBody ResponseEntity ChoosePay(Order payment) {
        payment = this.orderService.save(payment);
        return ResponseEntity.ok(payment);
    }

    /**
     * POST  /pay/type : pay the order
     * @param payment payment information
     * @return HTTP Status with payment information
     */
    @PostMapping("/pay")
    public @ResponseBody ResponseEntity Pay(Order payment) {
        payment = this.orderService.save(payment);
        return ResponseEntity.ok(payment);
    }

    /**
     * GET  /dues : get the member's dues
     * @return dues
     */
    @GetMapping("/dues")
    public @ResponseBody ResponseEntity getDues() {
        double price = 100.00d;
        return ResponseEntity.ok(price);
    }

    /**
     * GET  /duration : get the duration
     * @return duration
     */
    @GetMapping("/duration")
    public @ResponseBody ResponseEntity getDuration() {
        int duration = 4;
        return ResponseEntity.ok(duration);
    }

    /**
     * POST  /order : create order
     * @param payment payment information
     * @param invoice invoice information
     * @return HTTP Status with payment information
     */
    @PostMapping("/order")
    public @ResponseBody ResponseEntity order(Order payment, Invoice invoice) {
        payment = this.orderService.save(payment, invoice);
        return ResponseEntity.ok(payment);
    }
}
