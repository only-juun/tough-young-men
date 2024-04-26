package com.onlyjoon.tddstudy.domain.member;

import com.onlyjoon.tddstudy.domain.BaseEntity;
import com.onlyjoon.tddstudy.domain.memberRole.MemberRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true, length = 30)
    private String id;

    @Column(nullable = false, unique = true, length = 30)
    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MemberRole> memberRoles = new ArrayList<>();

    @Builder
    private Member(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
