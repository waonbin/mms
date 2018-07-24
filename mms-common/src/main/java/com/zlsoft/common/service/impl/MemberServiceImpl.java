package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MemberRepository;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.domain.Member;
import com.zlsoft.security.domain.User;
import com.zlsoft.security.repository.UserRepository;
import com.zlsoft.utils.RandomUtil;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Created by huangping on 12/11/2016.
 */
@Transactional
@Service("memberService")
public class MemberServiceImpl extends BaseSimpleService<Member, Long> implements MemberService {

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByName(String name) {
        return ((MemberRepository)this.getRepository()).findByName(name);
    }

    @Override
    public List<Member> findByEmail(String email) {
        return ((MemberRepository)this.getRepository()).findByEmail(email);
    }

    @Override
    public List<Member> findByNameOrEmail(String name, String email) {
        return ((MemberRepository)this.getRepository()).findByNameOrEmail(name, email);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByNameAndPassword(String name, String password) {
        return ((MemberRepository)this.getRepository()).findByNameAndPassword(name, password);
    }

    @Override
    public Page<Member> findByMemberType(Short memberType, Pageable pageable) {
        return ((MemberRepository)this.getRepository()).findByMemberType(memberType, pageable);
    }

    @Override
    public Member save(Member member) {

        User user = new User();

        user.setLogin(member.getName());
        user.setPassword(passwordEncoder.encode(member.getPassword()));
        user.setFirstName(member.getName());
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
        user.setEmail(member.getEmail());
//        user.setImageUrl(userDTO.getImageUrl());
//        user.setLangKey(userDTO.getLangKey());
        user.setActivated(false);
        user.setActivationKey(RandomUtil.generateActivationKey());

        user = this.userRepository.save(user);

        member.setUserId(user.getId());
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        return this.getRepository().save(member);
    }

    public Member findByLogin(String login) {
        Optional<User> user = this.userRepository.findOneByLogin(login);

        if(user.isPresent()) {
            Optional<Member> member = ((MemberRepository)this.getRepository()).findOneByUserId(user.get().getId());

            if(member.isPresent()) {
                return member.get();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
