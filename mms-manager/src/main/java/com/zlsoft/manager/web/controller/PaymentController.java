package com.zlsoft.manager.web.controller;

import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;
import com.zlsoft.manager.Constants;
import com.zlsoft.manager.web.vm.OrderVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.Optional;

@Controller("AdminPaymentController")
@RequestMapping("/admin/payment")
public class PaymentController {

    @Inject
    private PaymentService paymentService;

    @Inject
    private MemberService memberService;

    /**
     * GET  /payment : get payment check page
     * @return payment check page
     */
    @GetMapping("/payment_check")
    public String paymentCheck() {
        return "/admin/finance/payment_check";
    }

    /**
     * GET  /payment_check/page/{page} : get data of payment check by page
     * @param page zero-based page index
     * @return data of payment check by page
     */
    @GetMapping("/payment_check/page/{page}")
    public @ResponseBody
    ResponseEntity getPaymentChecks(@PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Payment> members = this.paymentService.findAll(pageRequest);
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /payment : get members' payments page
     * @return members' payments page
     */
    @GetMapping("/member_payments")
    public String memberPayments() {
        return "/admin/finance/member_payments";
    }

    /**
     * GET  /member_payments/page/{page} : get data of member payment by page
     * @param page zero-based page index
     * @return data of member payment by page
     */
    @GetMapping("/member_payments/page/{page}")
    public @ResponseBody
    ResponseEntity getMemberPayments(@PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Payment> members = this.paymentService.findAll(pageRequest);
        return ResponseEntity.ok(members);
    }


    /**
     * GET  /details : get group payment' details info page
     * @return group member' details info page
     */
    @GetMapping("/details")
    public String details() {
        return "/admin/finance/details";
    }

    /**
     * GET  /details : get member' order info
     * @param id order id
     * @return member' order info
     */
    @GetMapping("/details/{id}")
    public @ResponseBody ResponseEntity details(@PathVariable long id) {
        Optional<Payment> payment = this.paymentService.findById(id);

        if(payment.isPresent()) {
            Optional<Member> member = this.memberService.findById(payment.get().getMemberId());
            return ResponseEntity.ok(new OrderVM(payment.get(), member.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
