package com.zlsoft.core.repository;

import com.zlsoft.core.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberRepository extends JpaRepository<Member, Long>, BaseRepository<Member, Long> {

    Member findByEmail(String email);
    Member findByUsername(String username);
    Member findByPassword(String password);
    Member findByTelephone(String telephone);

    Page<Member> findAll(Pageable pageable);

}
