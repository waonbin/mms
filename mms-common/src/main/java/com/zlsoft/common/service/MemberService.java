package com.zlsoft.common.service;

import com.zlsoft.common.web.vm.MemberVM;
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

    Page<Member> findByMemberType(Short memberType, Pageable pageable);

    MemberVM findByLogin(String login);

    MemberVM findVMById(Long id);

    MemberVM save(MemberVM member);
}
