package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.MemberRepository;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.service.mapper.MemberMapper;
import com.zlsoft.common.web.vm.MemberVM;
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

    @Inject
    private MemberMapper memberMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByName(String name) {
        return ((MemberRepository) this.getRepository()).findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByEmail(String email) {
        return ((MemberRepository) this.getRepository()).findByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Member> findByNameOrEmail(String name, String email) {
        return ((MemberRepository) this.getRepository()).findByNameOrEmail(name, email);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Member> findByMemberType(Short memberType, Pageable pageable) {
        return ((MemberRepository) this.getRepository()).findByMemberType(memberType, pageable);
    }

    @Override
    public MemberVM save(MemberVM memberVM) {

        User user;

        if (memberVM.getUserId() == null) {
            user = new User();
        } else {
            Optional<User> optionalUser = this.userRepository.findById(memberVM.getUserId());

            if (optionalUser.isPresent()) {
                user = optionalUser.get();
            } else {
                user = new User();
            }
        }

        user.setLogin(memberVM.getLogin());
        user.setPassword(passwordEncoder.encode(memberVM.getPassword()));
        user.setFirstName(memberVM.getFirstName());
        user.setLastName(memberVM.getLastName());
        user.setEmail(memberVM.getEmail());
//        user.setImageUrl(userDTO.getImageUrl());
//        user.setLangKey(userDTO.getLangKey());
        user.setActivated(false);
        user.setActivationKey(RandomUtil.generateActivationKey());

        user = this.userRepository.save(user);

        if (user != null) {
            memberVM.setUserId(user.getId());
        }
        memberVM.setPassword(passwordEncoder.encode(memberVM.getPassword()));

        Member member = memberMapper.memberVMToMember(memberVM);
        member = this.getRepository().save(member);

        return new MemberVM(member, user);
    }

    @Transactional(readOnly = true)
    @Override
    public MemberVM findByLogin(String login) {
        Optional<User> user = this.userRepository.findOneByLogin(login);

        if (user.isPresent()) {
            Optional<Member> member = ((MemberRepository) this.getRepository()).findOneByUserId(user.get().getId());

            if (member.isPresent()) {
                return new MemberVM(member.get(), user.get());
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public MemberVM findVMById(Long id) {
        Optional<Member> member = this.findById(id);

        if(member.isPresent()) {
            Optional<User> user = this.userRepository.findById(member.get().getUserId());

            return new MemberVM(member.get(), user.orElse(null));
        }

        return null;
    }

}
