package com.remind.api.member.dto.response;

import lombok.Builder;

@Builder
public record TokenResponseDto(
    String accessToken,
    String refreshToken
) {

}
