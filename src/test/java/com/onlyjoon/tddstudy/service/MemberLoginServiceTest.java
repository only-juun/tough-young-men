package com.onlyjoon.tddstudy.service;

import com.onlyjoon.tddstudy.controller.request.MemberLoginRequest;
import com.onlyjoon.tddstudy.domain.Member;
import com.onlyjoon.tddstudy.domain.MemberRole;
import com.onlyjoon.tddstudy.domain.Role;
import com.onlyjoon.tddstudy.repository.MemberRoleRepository;
import com.onlyjoon.tddstudy.repository.RoleRepository;
import com.onlyjoon.tddstudy.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberLoginServiceTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MemberRoleRepository memberRoleRepository;

    @Autowired
    private MemberLoginService memberLoginService;

    @Test
    @DisplayName("관리자는 관리자 페이지에 로그인 할 수 있다.")
    void login() {
        // given: 관리자 유저와, 관리자인 사용자의 로그인 정보가 주어지고,
        Role adminRole = Role.builder()
                .roleName("ADMIN")
                .build();
        roleRepository.save(adminRole);

        Member adminUser = createMember("admin", "admin123!@");
        memberRepository.save(adminUser);

        MemberRole memberRole = MemberRole.builder()
                .role(adminRole)
                .member(adminUser)
                .build();
        memberRoleRepository.save(memberRole);

        MemberLoginRequest request = MemberLoginRequest.builder()
                .id("admin")
                .password("admin123!@")
                .build();

        // when: 로그인 요청이 왔을 때
        String result = memberLoginService.login(request);

        // then
        assertThat(result).isEqualTo("login success");
    }


    private static Member createMember(String id, String password) {
        return Member.builder()
                .id(id)
                .password(password)
                .build();
    }
}