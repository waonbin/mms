package com.zlsoft.core.service;

import com.zlsoft.core.domain.Member;

import java.util.List;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberService extends SimpleService<Member, Long> {

    Member findByEmail(String email);

    Member findByUsername(String username);

    Member findByTelephone(String telephone);
    /**
     * 根据密码进行查询
     * @return
     */
    Member findByPassword(String password);

    int changePassword(Long id, String oldPassword, String newPassword);

}
