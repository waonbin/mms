package com.zlsoft.utils.repository;

import com.zlsoft.utils.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberRepository extends JpaRepository<Member, Long>, BaseRepository<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByNameAndPassword(String name, String password);

    Page<Member> findAll(Pageable pageable);

}
