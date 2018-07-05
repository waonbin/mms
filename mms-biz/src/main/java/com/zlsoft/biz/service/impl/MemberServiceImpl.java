package com.zlsoft.biz.service.impl;

import com.zlsoft.biz.domain.Member;
import com.zlsoft.biz.repository.MemberRepository;
import com.zlsoft.biz.service.MemberService;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by huangping on 12/11/2016.
 */
@Transactional
@Service("memberService")
public class MemberServiceImpl extends BaseSimpleService<Member, Long> implements MemberService {

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByName(String name) {
        return ((MemberRepository)this.getRepository()).findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByNameAndPassword(String name, String password) {
        return ((MemberRepository)this.getRepository()).findByNameAndPassword(name, password);
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
