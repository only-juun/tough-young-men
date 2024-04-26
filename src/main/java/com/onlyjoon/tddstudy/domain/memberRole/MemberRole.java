package com.onlyjoon.tddstudy.domain.memberRole;

import com.onlyjoon.tddstudy.domain.BaseEntity;
import com.onlyjoon.tddstudy.domain.member.Member;
import com.onlyjoon.tddstudy.domain.role.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberRoleId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;
}
