package com.onlyjoon.tddstudy.controller.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberLoginRequest {

    private String id;
    private String password;

    @Builder
    private MemberLoginRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }

}
