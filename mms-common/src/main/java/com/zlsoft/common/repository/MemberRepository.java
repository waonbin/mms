package com.zlsoft.common.repository;

import com.zlsoft.domain.Member;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberRepository extends JpaRepository<Member, Long>, BaseRepository<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByEmail(String email);

    List<Member> findByNameOrEmail(String name, String email);

    List<Member> findByNameAndPassword(String name, String password);

    Page<Member> findAll(Pageable pageable);

}
