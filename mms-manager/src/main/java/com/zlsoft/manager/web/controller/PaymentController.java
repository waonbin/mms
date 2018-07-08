package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller("AdminPaymentController")
@RequestMapping("/admin/payment")
public class PaymentController {

    @Inject
    private PaymentService paymentService;

    /**
     * GET  /payment : get payment check page
     * @return payment check page
     */
    @GetMapping("/payment_check")
    public ModelAndView paymentCheck() {

        List<Payment> payments = this.paymentService.findAll();
        ModelAndView mav = new ModelAndView("/admin/finance/payment_check");
        mav.addObject("payments", payments);

        return mav;
    }

    /**
     * GET  /payment : get members' payments page
     * @return members' payments page
     */
    @GetMapping("/member_payments")
    public ModelAndView memberPayments() {

        List<Payment> payments = this.paymentService.findAll();
        ModelAndView mav = new ModelAndView("/admin/finance/member_payments");
        mav.addObject("payments", payments);

        return mav;
    }
}
