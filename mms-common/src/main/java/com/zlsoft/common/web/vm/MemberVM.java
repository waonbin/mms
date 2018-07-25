package com.zlsoft.common.web.vm;

import com.zlsoft.domain.Member;
import com.zlsoft.security.domain.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberVM extends Member {

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date admitDateStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date admitDateEnd;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdayStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdayEnd;

    public MemberVM(Member member, User user) {

        if(member != null) {
            this.setId(member.getId());
            this.setUserId(member.getUserId());
            this.setEmail(member.getEmail());
            this.setName(member.getName());
            this.setMemberType(member.getMemberType());
            this.setMobile(member.getMobile());
            this.setReference(member.getReference());
            this.setGender(member.getGender());
            this.setBirthday(member.getBirthday());
            this.setCompany(member.getCompany());
            this.setTitle(member.getTitle());
            this.setNationality(member.getNationality());
            this.setPartisan(member.getPartisan());
            this.setMajor(member.getMajor());
            this.setWorkajor(member.getWorkajor());
            this.setEducation(member.getEducation());
            this.setLevel(member.getLevel());
            this.setWechat(member.getWechat());
            this.setOicq(member.getOicq());
            this.setFax(member.getFax());
            this.setTelephone(member.getTelephone());
            this.setZipcode(member.getZipcode());
            this.setProvince(member.getProvince());
            this.setCity(member.getCity());
            this.setAddress(member.getAddress());
            this.setFullAddress(member.getFullAddress());
            this.setResearchField(member.getResearchField());
            this.setMemberNo(member.getMemberNo());
            this.setExistMemberNo(member.getExistMemberNo());
            this.setSchool(member.getSchool());
            this.setWorkNature(member.getWorkNature());
            this.setJobPerformance(member.getJobPerformance());
            this.setExpiryDate(member.getExpiryDate());
            this.setStatus(member.getStatus());
            this.setAdmitYear(member.getAdmitYear());
        }

        if(user != null) {
            this.setLogin(user.getLogin());
            this.setPassword(user.getPassword());
            this.setFirstName(user.getFirstName());
            this.setLastName(user.getLastName());
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getAdmitDateStart() {
        return admitDateStart;
    }

    public void setAdmitDateStart(Date admitDateStart) {
        this.admitDateStart = admitDateStart;
    }

    public Date getAdmitDateEnd() {
        return admitDateEnd;
    }

    public void setAdmitDateEnd(Date admitDateEnd) {
        this.admitDateEnd = admitDateEnd;
    }

    public Date getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(Date birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public Date getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(Date birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }
}
