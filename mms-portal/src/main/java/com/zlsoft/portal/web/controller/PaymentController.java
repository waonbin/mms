package com.zlsoft.portal.web.controller;

import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;
import com.zlsoft.portal.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
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
