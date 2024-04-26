package com.onlyjoon.tddstudy.service;

import com.onlyjoon.tddstudy.controller.request.MemberLoginRequest;
import com.onlyjoon.tddstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberLoginService {

    private final MemberRepository memberRepository;

    public String login(MemberLoginRequest memberLoginRequest) {
        return "login success";
    }

}
