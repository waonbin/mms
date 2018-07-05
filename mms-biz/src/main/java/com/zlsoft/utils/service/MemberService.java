package com.zlsoft.utils.service;

import com.zlsoft.utils.domain.Member;

import java.util.List;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberService extends SimpleService<Member, Long> {


    List<Member> findByNameAndPassword(String name, String password);

    Member findByEmail(String email);



    Member findByTelephone(String telephone);
    /**
     * 根据密码进行查询
     * @return
     */
    Member findByPassword(String password);

    int changePassword(Long id, String oldPassword, String newPassword);

}
