package com.remind.api.member.controller;

import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.protobuf.Api;
import com.remind.api.member.dto.request.RefreshTokenRequestDto;
import com.remind.api.member.dto.response.TokenResponseDto;
import com.remind.api.member.service.MemberService;
import com.remind.core.domain.common.response.ApiSuccessResponse;
import com.remind.core.security.dto.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/token")
@RequiredArgsConstructor
@Tag(name = "member token API", description = "member token 관련 API 문서")
public class MemberTokenController {

    private final MemberService memberService;

    @Operation(
            summary = "토큰 갱신 API",
            description = "refresh token을 사용하여 access token와 refresh token을 갱신한다."
    )
    @PostMapping("/refresh")
    public ResponseEntity<ApiSuccessResponse<TokenResponseDto>> refreshToken(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @Valid @RequestBody RefreshTokenRequestDto dto
    ) {
        return ResponseEntity.ok(
                new ApiSuccessResponse<>(memberService.refreshToken(dto.refreshToken(), userDetails.getMemberId())));
    }

    @PostMapping("/device")
    public ResponseEntity<ApiSuccessResponse<Message>> deviceRegistrationToken() {
        return ResponseEntity.ok(new ApiSuccessResponse<>(Message.builder()
                .setToken("gg")
                .setNotification(Notification.builder()
                        .setTitle("$GOOG up 1.43% on the day")
                        .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
                        .build())
                .build()));
    }
}
