package com.remind.core.domain.member.repository;

import com.remind.core.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByAuthId(Long authId);

    Optional<Member> findByMemberCode(String memberCode);
}
