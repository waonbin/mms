package com.zlsoft.utils.service;

import com.zlsoft.utils.domain.Member;

import java.util.List;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberService extends SimpleService<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByNameAndPassword(String name, String password);

    int changePassword(Long id, String oldPassword, String newPassword);

}
