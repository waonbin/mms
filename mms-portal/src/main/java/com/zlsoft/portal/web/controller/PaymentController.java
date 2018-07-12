package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;
import com.zlsoft.portal.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Inject
    private PaymentService paymentService;

    /**
     * GET  /payment : get payment page
     * @param session the HTTP Session
     * @return payment page
     */
    @GetMapping
    public ModelAndView payment(HttpSession session) {
        ModelAndView mav = new ModelAndView("/member/personal_payment");

        Member member = (Member) session.getAttribute(Constants.SESSION_USER);

        if(member != null) {
            List<Payment> payments = this.paymentService.findByMemberId(member.getId());
            mav.addObject("payments", payments);
        }

        return mav;
    }

    /**
     * GET  /page/{page} : get payment data by page
     * @param session the HTTP Session
     * @param page zero-based page index
     * @return payment data by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody Page<Payment> getPayments(HttpSession session, @PathVariable("page") int page){

        Member member = (Member) session.getAttribute(Constants.SESSION_USER);

        Specification<Payment> spec = (root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            list.add(cb.equal(root.get("memberId").as(Long.class), member.getId()));
            Predicate[] predicates = new Predicate[list.size()];
            query.where(cb.and(list.toArray(predicates)));
            return query.getRestriction();
        };

        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);

        return this.paymentService.findAll(spec, pageRequest);
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
     * POST  /order : create order
     * @param payment order information
     * @return HTTP Status with payment information
     */
    @PostMapping("/order")
    public ResponseEntity order(Payment payment) {
        payment = this.paymentService.save(payment);
        return ResponseEntity.ok(payment);
    }

    /**
     * POST  /pay/type : choose the pay type
     * @param payment payment information
     * @return HTTP Status with payment information
     */
    @PostMapping("/pay/type")
    public ResponseEntity ChoosePay(Payment payment) {
        payment = this.paymentService.save(payment);
        return ResponseEntity.ok(payment);
    }

    /**
     * POST  /pay/type : pay the order
     * @param payment payment information
     * @return HTTP Status with payment information
     */
    @PostMapping("/pay")
    public ResponseEntity Pay(Payment payment) {
        payment = this.paymentService.save(payment);
        return ResponseEntity.ok(payment);
    }
}
