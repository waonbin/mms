package com.zlsoft.core.service.impl;

import com.zlsoft.core.domain.Member;
import com.zlsoft.core.repository.MemberRepository;
import com.zlsoft.core.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by huangping on 12/11/2016.
 */
@Transactional
@Service("userService")
public class MemberServiceImpl extends BaseSimpleService<Member, Long> implements MemberService {


    @Transactional(readOnly = true)
    @Override
    public Member findByEmail(String email) {
        return ((MemberRepository)this.getRepository()).findByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public Member findByUsername(String username) {
        return ((MemberRepository)this.getRepository()).findByUsername(username);
    }

    @Transactional(readOnly = true)
    @Override
    public Member findByTelephone(String telephone) {
        return ((MemberRepository)this.getRepository()).findByTelephone(telephone);
    }

    @Transactional(readOnly = true)
    @Override
    public Member findByPassword(String password) {
        return ((MemberRepository)this.getRepository()).findByPassword(password);
    }

    @Override
    public int changePassword(Long id, String oldPassword, String newPassword) {

        Optional<Member> member = this.findById(id);

        if(!member.isPresent()) {
            return -2;
        }

        if(!member.get().getPassword().equals(oldPassword)) {
            return -3;
        }

        member.get().setPassword(newPassword);

        if(this.save(member.get())!=null){
            return 1;
        }
        return 0;
    }

}
