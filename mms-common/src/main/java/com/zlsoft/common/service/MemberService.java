package com.zlsoft.common.service;

import com.zlsoft.domain.Member;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberService extends SimpleService<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByEmail(String email);

    List<Member> findByNameOrEmail(String name, String email);

    List<Member> findByNameAndPassword(String name, String password);

    Page<Member> findByMemberType(Short memberType, Pageable pageable);

    Member findByLogin(String login);
}
