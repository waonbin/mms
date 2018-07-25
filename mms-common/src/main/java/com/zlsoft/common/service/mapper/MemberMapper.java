package com.zlsoft.common.service.mapper;

import com.zlsoft.common.web.vm.MemberVM;
import com.zlsoft.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberMapper {

    public Member memberVMToMember(MemberVM memberVM) {
        if(memberVM == null) {
            return null;
        } else {
            Member member = new Member();

            member.setId(memberVM.getId());
            member.setUserId(memberVM.getUserId());
            member.setEmail(memberVM.getEmail());
            member.setName(memberVM.getName());
            member.setMemberType(memberVM.getMemberType());
            member.setMobile(memberVM.getMobile());
            member.setReference(memberVM.getReference());
            member.setGender(memberVM.getGender());
            member.setBirthday(memberVM.getBirthday());
            member.setCompany(memberVM.getCompany());
            member.setTitle(memberVM.getTitle());
            member.setNationality(memberVM.getNationality());
            member.setPartisan(memberVM.getPartisan());
            member.setMajor(memberVM.getMajor());
            member.setWorkajor(memberVM.getWorkajor());
            member.setEducation(memberVM.getEducation());
            member.setLevel(memberVM.getLevel());
            member.setWechat(memberVM.getWechat());
            member.setOicq(memberVM.getOicq());
            member.setFax(memberVM.getFax());
            member.setTelephone(memberVM.getTelephone());
            member.setZipcode(memberVM.getZipcode());
            member.setProvince(memberVM.getProvince());
            member.setCity(memberVM.getCity());
            member.setAddress(memberVM.getAddress());
            member.setFullAddress(memberVM.getFullAddress());
            member.setResearchField(memberVM.getResearchField());
            member.setMemberNo(memberVM.getMemberNo());
            member.setExistMemberNo(memberVM.getExistMemberNo());
            member.setSchool(memberVM.getSchool());
            member.setWorkNature(memberVM.getWorkNature());
            member.setJobPerformance(memberVM.getJobPerformance());
            member.setExpiryDate(memberVM.getExpiryDate());
            member.setStatus(memberVM.getStatus());
            member.setAdmitYear(memberVM.getAdmitYear());

            return member;
        }
    }
}
