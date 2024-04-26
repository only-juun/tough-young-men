package com.onlyjoon.tddstudy.repository.member;

import com.onlyjoon.tddstudy.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(String id);
}
