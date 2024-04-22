package com.remind.core.domain.member;

import com.remind.core.domain.member.enums.RolesType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member", indexes = {
        @Index(name = "idx_authId", columnList = "authId"),
        @Index(name = "idx_registration_token", columnList = "registrationToken")
})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long authId; // 소셜 로그인 고유 회원 식별 값

    private String name;

    @Enumerated(value = EnumType.STRING)
    private RolesType rolesType;

    private String registrationToken; // 기기 등록 토큰

}
