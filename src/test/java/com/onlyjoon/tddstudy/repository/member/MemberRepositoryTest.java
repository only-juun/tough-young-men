package com.onlyjoon.tddstudy.repository.member;

import com.onlyjoon.tddstudy.domain.Member;
import com.onlyjoon.tddstudy.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("존재하는 사용자를 조회할 수 있다.")
    void findExistMember() {
        // given
        Member member = createMember("abc1234", "encryptedPassword");

        memberRepository.save(member);

        // when
        Optional<Member> savedMember = memberRepository.findById("abc1234");

        // then
        assertThat(savedMember).isPresent();

    }

    @Test
    @DisplayName("존재하지 않는 사용자를 조회할 수 없다.")
    void findNotExistMember() {
        // given
        Member member = createMember("abc1234", "encryptedPassword");

        memberRepository.save(member);

        // when
        Optional<Member> savedMember = memberRepository.findById("abc1233");

        // then
        assertThat(savedMember).isNotPresent();
    }

    @Test
    @DisplayName("사용자 전체를 조회할 수 있다.")
    void findMembers() {
        // given
        Member member1 = createMember("abc123", "encryptedPassword1");
        Member member2 = createMember("abc456", "encryptedPassword2");
        Member member3 = createMember("abc789", "encryptedPassword3");

        memberRepository.saveAll(List.of(member1, member2, member3));

        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members).hasSize(3)
                .extracting(Member::getId, Member::getPassword).containsExactlyInAnyOrder(
                        tuple("abc123", "encryptedPassword1"),
                        tuple("abc456", "encryptedPassword2"),
                        tuple("abc789", "encryptedPassword3")
                );

    }

    private static Member createMember(String id, String password) {
        return Member.builder()
                .id(id)
                .password(password)
                .build();
    }
}