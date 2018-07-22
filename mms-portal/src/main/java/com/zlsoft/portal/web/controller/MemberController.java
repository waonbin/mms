package com.zlsoft.portal.web.controller;

import com.google.common.base.Strings;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
import com.zlsoft.portal.Constants;
import com.zlsoft.utils.MD5Util;
import com.zlsoft.utils.web.controller.BaseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

    @Inject
    private MemberService memberService;

    /**
     * GET  /register : get register page
     * @return register page
     */
    @GetMapping("/register")
    public String register() {
        return "/member/register1";
    }

    /**
     * POST  /register : register member
     * @param member member info
     * @return register success page
     * @throws URISyntaxException
     */
    @PostMapping("/register")
    public ResponseEntity register(HttpSession session, Member member) throws URISyntaxException {
        String password = MD5Util.getMD5WithBase64(member.getPassword());
        member.setPassword(password);
        member = this.memberService.save(member);
        session.setAttribute(Constants.SESSION_USER, member);
        return ResponseEntity.created(new URI("/member/register3")).body(member);
    }

    /**
     * GET  /register3 : get register success page
     * @return register success page
     */
    @GetMapping("/register3")
    public String register3() {
        return "/member/register3";
    }

    /**
     * GET  /check/email : check if email is already registered
     * @param email the Email address
     * @return HTTP Status with information
     */
    @GetMapping("/check/email")
    public @ResponseBody
    ResponseEntity checkEmail(String email){
        List<Member> members = this.memberService.findByEmail(email);

        if(members.size() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的邮箱已注册！");
        } else {
            return ResponseEntity.ok().build();
        }
    }

    /**
     * GET  /check/name : check if name is already registered
     * @param name the user name
     * @return HTTP Status with information
     */
    @GetMapping("/check/name")
    public @ResponseBody
    ResponseEntity checkName(String name){
        List<Member> members = this.memberService.findByName(name);
        if(members.size() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("您所输入的用户名已注册！");
        } else {
            return ResponseEntity.ok().build();
        }
    }

    /**
     * GET  /check/password : check if password is already registered
     * @param session the HTTP Session
     * @param password the user password
     * @return HTTP Status with information
     */
    @GetMapping("/check/password")
    public @ResponseBody
    ResponseEntity checkPassword(HttpSession session, String password){
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        String passwordEncoded = MD5Util.getMD5WithBase64(password);

        if(!member.getPassword().equals(passwordEncoded)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密码错误！");
        } else {
            return ResponseEntity.ok().build();
        }
    }

    /**
     * GET  /personal_information : get personal information page
     * @param session the HTTP Session
     * @return personal information page with data
     */
    @GetMapping("/personal_information")
    public ModelAndView info(HttpSession session) {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        ModelAndView mav = new ModelAndView("/member/personal_information");
        mav.addObject("member", member);
        return mav;
    }

    /**
     * GET  /edit : get personal information edit page
     * @param session the HTTP Session
     * @return personal information edit page
     * @throws URISyntaxException
     */
    @GetMapping("/edit")
    public ModelAndView edit(HttpSession session) {
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        ModelAndView mav = new ModelAndView("/member/personal_edit");
        mav.addObject("member", member);
        return mav;
    }

    /**
     * POST  /edit : edit personal information
     * @param session the HTTP Session
     * @param member member information
     * @return personal information edit page
     * @throws URISyntaxException
     */
    @PostMapping("/edit")
    public ResponseEntity edit(HttpSession session, Member member) {
        Optional<Member> memberInDB = this.memberService.findById(member.getId());

        if(memberInDB.isPresent()) {
            member = this.memberService.save(copyFields(memberInDB.get(), member));
            session.setAttribute(Constants.SESSION_USER, member);
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * GET  /revise : get member card page
     * @return member card page
     */
    @GetMapping("/card")
    public String card() {
        return "/member/membercard";
    }


    /**
     * GET  /revise : get revise page
     * @return revise page
     */
    @GetMapping("/revise")
    public String revise() {
        return "/member/personal_revise";
    }


    /**
     * POST  /password : change password
     * @param session the HTTP Session
     * @param newPassword new password
     * @return HTTP Status with information
     */
    @PostMapping("/password")
    public ResponseEntity changePassword(HttpSession session, String newPassword){
        Member member = (Member) session.getAttribute(Constants.SESSION_USER);
        String passwordEncoded = MD5Util.getMD5WithBase64(newPassword);
        member.setPassword(passwordEncoded);

        this.memberService.save(member);
        session.setAttribute(Constants.SESSION_USER, member);

        return ResponseEntity.ok().build();
    }

    /**
     * copy values from right to left if it is not null
     * @param left left model
     * @param right right model
     * @return left model
     */
    private Member copyFields(Member left, Member right) {

        if(!Strings.isNullOrEmpty(right.getEmail())) left.setEmail(right.getEmail());
        if(!Strings.isNullOrEmpty(right.getName())) left.setName(right.getName());
        if(right.getMemberType() != null) left.setMemberType(right.getMemberType());
        if(!Strings.isNullOrEmpty(right.getMobile())) left.setMobile(right.getMobile());
        if(right.getReference() != null) left.setReference(right.getReference());
        if(right.getGender() != null) left.setGender(right.getGender());
        if(right.getBirthday() != null) left.setBirthday(right.getBirthday());
        if(right.getPartisan() != null) left.setPartisan(right.getPartisan());
        if(!Strings.isNullOrEmpty(right.getMajor())) left.setMajor(right.getMajor());
        if(!Strings.isNullOrEmpty(right.getWorkajor())) left.setWorkajor(right.getWorkajor());
        if(right.getEducation() != null) left.setEducation(right.getEducation());
        if(right.getLevel() != null) left.setLevel(right.getLevel());
        if(!Strings.isNullOrEmpty(right.getWechat())) left.setWechat(right.getWechat());
        if(!Strings.isNullOrEmpty(right.getOicq())) left.setOicq(right.getOicq());
        if(!Strings.isNullOrEmpty(right.getFax())) left.setFax(right.getFax());
        if(!Strings.isNullOrEmpty(right.getTelephone())) left.setTelephone(right.getTelephone());
        if(!Strings.isNullOrEmpty(right.getZipcode())) left.setZipcode(right.getZipcode());
        if(right.getProvince() != null) left.setProvince(right.getProvince());
        if(right.getCity() != null) left.setCity(right.getCity());
        if(!Strings.isNullOrEmpty(right.getAddress())) left.setAddress(right.getAddress());
        if(!Strings.isNullOrEmpty(right.getFullAddress())) left.setFullAddress(right.getFullAddress());
        if(!Strings.isNullOrEmpty(right.getResearchField())) left.setResearchField(right.getResearchField());
        if(!Strings.isNullOrEmpty(right.getMemberNo())) left.setMemberNo(right.getMemberNo());
        if(!Strings.isNullOrEmpty(right.getSchool())) left.setSchool(right.getSchool());
        if(right.getWorkNature() != null) left.setWorkNature(right.getWorkNature());
        if(!Strings.isNullOrEmpty(right.getJobPerformance())) left.setJobPerformance(right.getJobPerformance());
        if(right.getExpiryDate() != null) left.setExpiryDate(right.getExpiryDate());

        return left;
    }

}
