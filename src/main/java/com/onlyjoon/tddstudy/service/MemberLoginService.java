package com.onlyjoon.tddstudy.service;

import com.onlyjoon.tddstudy.controller.request.MemberLoginRequest;
import com.onlyjoon.tddstudy.domain.Member;
import com.onlyjoon.tddstudy.domain.MemberRole;
import com.onlyjoon.tddstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final MemberRepository memberRepository;

    public String login(MemberLoginRequest request) {
        Member member = memberRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        validatePassword(request.getPassword(), member.getPassword());

        List<MemberRole> memberRoles = member.getMemberRoles();
        validateAdmin(memberRoles);

        return "login success";
    }

    private static void validatePassword(String request, String member) {
        if (!request.equals(member)) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
    }

    private static void validateAdmin(List<MemberRole> memberRoles) {
        boolean isAdmin = memberRoles.stream()
                .map(MemberRole::getRole)
                .anyMatch(role -> role.getRoleName().equals("ADMIN"));

        if (!isAdmin) {
            throw new IllegalArgumentException("관리자 권한이 없습니다.");
        }
    }

}
