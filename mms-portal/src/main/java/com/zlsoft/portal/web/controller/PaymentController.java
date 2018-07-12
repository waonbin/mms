package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;
import com.zlsoft.portal.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
//            List<Payment> payments = this.paymentService.findByMemberId(member.getId());
//            mav.addObject("payments", payments);
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
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);

        return this.paymentService.findByMemberId(member.getId(), pageRequest);
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
