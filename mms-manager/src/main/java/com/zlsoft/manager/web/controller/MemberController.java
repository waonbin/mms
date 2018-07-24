package com.zlsoft.manager.web.controller;

import com.google.common.base.Strings;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.web.controller.BaseController;
import com.zlsoft.domain.Member;
import com.zlsoft.manager.Constants;
import com.zlsoft.manager.web.vm.MemberVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller(value = "AdminMemberController")
@RequestMapping("/admin/member")
public class MemberController extends BaseController {

    @Inject
    private MemberService memberService;

    /**
     * GET  /personal_information : get individual members' list page
     * @return individual members' list page
     */
    @GetMapping("/individual_members")
    public String individualMembers() {
        return "/admin/member/individual_members";
    }

    /**
     * GET  /personal_information/data : get data of individual members' list page
     * @return data of individual members' list page
     */
    @GetMapping("/individual_members/data")
    public @ResponseBody ResponseEntity getIndividualMembers() {
        List<Member> members = this.memberService.findAll();
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /query/{page} : get data of members' list page with conditions
     * @param page zero-based page index
     * @param memberVM query conditions
     * @return data of query result
     */
    @GetMapping("/query/{page}")
    public @ResponseBody ResponseEntity getIndividualMembers(@PathVariable("page") int page, MemberVM memberVM) {
        Specification<Member> specification = (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            //会员名称
            if (!Strings.isNullOrEmpty(memberVM.getName())) {
                predicates.add(cb.like(root.get("name").as(String.class), "%" + memberVM.getName() + "%"));
            }

            //推荐机构
            if (memberVM.getReference() != null) {
                predicates.add(cb.equal(root.get("reference").as(Short.class), memberVM.getReference()));
            }

            //职称
            if (memberVM.getLevel() != null) {
                predicates.add(cb.equal(root.get("level").as(Short.class), memberVM.getLevel()));
            }

            //党派类型
            if (memberVM.getPartisan() != null) {
                predicates.add(cb.equal(root.get("partisan").as(Short.class), memberVM.getPartisan()));
            }

            //会员类型
            if (memberVM.getMemberType() != null) {
                predicates.add(cb.equal(root.get("memberType").as(Short.class), memberVM.getMemberType()));
            }

            //学历
            if (memberVM.getEducation() != null) {
                predicates.add(cb.equal(root.get("education").as(Short.class), memberVM.getEducation()));
            }

            //毕业院校
            if (!Strings.isNullOrEmpty(memberVM.getSchool())) {
                predicates.add(cb.equal(root.get("school").as(String.class), memberVM.getSchool()));
            }

            //会员号
            if (!Strings.isNullOrEmpty(memberVM.getMemberNo())) {
                predicates.add(cb.equal(root.get("memberNo").as(String.class), memberVM.getMemberNo()));
            }

            //入会时间
//            if(memberVM.getAdmitDateStart() != null && memberVM.getAdmitDateEnd() != null) {
//                predicates.add(cb.between(root.get("admitDate").as(Date.class), memberVM.getAdmitDateStart(), memberVM.getAdmitDateEnd()));
//            } else if(memberVM.getAdmitDateStart() != null) {
//                predicates.add(cb.greaterThanOrEqualTo(root.get("admitDate").as(Date.class), memberVM.getAdmitDateStart()));
//            } else if(memberVM.getAdmitDateEnd() != null) {
//                predicates.add(cb.lessThanOrEqualTo(root.get("admitDate").as(Date.class), memberVM.getAdmitDateEnd()));
//            }

            //出生年月
            if(memberVM.getBirthdayStart() != null && memberVM.getBirthdayEnd() != null) {
                predicates.add(cb.between(root.get("birthday").as(Date.class), memberVM.getBirthdayStart(), memberVM.getBirthdayEnd()));
            } else if(memberVM.getBirthdayStart() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("birthday").as(Date.class), memberVM.getBirthdayStart()));
            } else if(memberVM.getBirthdayEnd() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("birthday").as(Date.class), memberVM.getBirthdayEnd()));
            }

            //省份
            if (memberVM.getProvince() != null) {
                predicates.add(cb.equal(root.get("province").as(Short.class), memberVM.getProvince()));
            }

            query.where(cb.and(predicates.stream().toArray(Predicate[]::new)));
            return query.getRestriction();
        };

        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Member> members = this.memberService.findAll(specification, pageRequest);

        return ResponseEntity.ok(members);
    }


    /**
     * GET  /page/{page} : get data of members by page
     * @param page zero-based page index
     * @param memberType member type code
     * @return data of members by page
     */
    @GetMapping("/page/{page}")
    public @ResponseBody ResponseEntity getMembers(@PathVariable("page") int page, short memberType) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Member> members = this.memberService.findByMemberType(memberType, pageRequest);
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /group_members : get group members' list page
     * @return group members' list page
     */
    @GetMapping("/group_members")
    public String groupMembers() {
        return "/admin/member/group_members";
    }

    /**
     * GET  /details : get group member' details info
     * @return group member' details info
     */
    @GetMapping("/details/{id}")
    public ResponseEntity details(@PathVariable("id") long id) {
        Optional<Member> member = this.memberService.findById(id);

        if(member.isPresent()){
            return ResponseEntity.ok(member.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET  /details : get group member' details info page
     * @return group member' details info page
     */
    @GetMapping("/details")
    public String details() {
        return "/admin/member/details";
    }

    /**
     * GET  /group_members/data : get data of group members' list page
     * @return data of group members' list page
     */
    @GetMapping("/group_members/data")
    public @ResponseBody ResponseEntity getGroupMembers() {
        List<Member> members = this.memberService.findAll();
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /personal_information : get group members' list page
     * @return group members' list page
     */
    @GetMapping("/register_check")
    public String registerCheck() {
        return "/admin/member/register_check";
    }

    /**
     * GET  /register_check/data : get data of group members' list page
     * @return data of group members' list page
     */
    @GetMapping("/register_check/data")
    public @ResponseBody ResponseEntity getRegisterCheck() {
        List<Member> members = this.memberService.findAll();
        return ResponseEntity.ok(members);
    }

    /**
     * GET  /register_check/page/{page} : get data of members by page
     * @param page zero-based page index
     * @return data of members by page
     */
    @GetMapping("/register_check/page/{page}")
    public @ResponseBody ResponseEntity getRegisterCheck(@PathVariable("page") int page) {
        PageRequest pageRequest = PageRequest.of(page, Constants.PAGE_SIZE);
        Page<Member> members = this.memberService.findAll(pageRequest);
        return ResponseEntity.ok(members);
    }
}
