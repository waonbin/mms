package com.zlsoft.common.repository;

import com.zlsoft.domain.Member;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by huangping on 03/11/2016.
 */
public interface MemberRepository extends JpaRepository<Member, Long>,
        JpaSpecificationExecutor<Member>,
        BaseRepository<Member, Long> {

    List<Member> findByName(String name);

    List<Member> findByEmail(String email);

    List<Member> findByNameOrEmail(String name, String email);

    @Query(value = "select m from Member m where m.memberType=:memberType")
    Page<Member> findByMemberType(@Param("memberType") Short memberType, Pageable pageable);

    Optional<Member> findOneByUserId(Long userId);

}
