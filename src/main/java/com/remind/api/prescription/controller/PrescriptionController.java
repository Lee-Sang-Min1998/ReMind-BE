package com.remind.api.prescription.controller;

import com.remind.api.prescription.dto.request.AcceptRelationRequestDto;
import com.remind.api.prescription.dto.request.RequestRelationRequestDto;
import com.remind.api.prescription.dto.response.AcceptRelationResponseDto;
import com.remind.api.prescription.dto.response.RequestRelationResponseDto;
import com.remind.api.prescription.service.PrescriptionService;
import com.remind.core.domain.common.response.ApiSuccessResponse;
import com.remind.core.security.dto.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescription")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "prescription API", description = "prescription 관련 API 문서")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Operation(
            summary = "환자 -> 의사 관계 요청 API",
            description = "환자가 의사의 멤버코드를 이용하여 관계를 요청하는 api"
    )
    @PostMapping("/relation/request")
    public ResponseEntity<ApiSuccessResponse<RequestRelationResponseDto>> requestRelataion(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @Valid @RequestBody RequestRelationRequestDto req) {
        return ResponseEntity.ok(new ApiSuccessResponse<>(prescriptionService.requestRelation(userDetails, req)));
    }

//    @Operation(
//            summary = "환자 -> 의사 관계 수락 API",
//            description = "의사가 환자의 관계 요청을 수락하는 api"
//    )
//    @PostMapping("/relation/accept")
//    public ResponseEntity<ApiSuccessResponse<AcceptRelationResponseDto>> AcceptRelataion(
//            @AuthenticationPrincipal UserDetailsImpl userDetails,
//            @Valid @RequestBody AcceptRelationRequestDto req) {
//        return ResponseEntity.ok(new ApiSuccessResponse<>(prescriptionService.requestRelation(userDetails, req)));
//    }


}