package com.zlsoft.manager.web.vm;

import com.zlsoft.domain.Member;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MemberVM extends Member {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date admitDateStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date admitDateEnd;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdayStart;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthdayEnd;

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
