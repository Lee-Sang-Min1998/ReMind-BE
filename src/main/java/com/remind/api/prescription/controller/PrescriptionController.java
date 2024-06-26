package com.remind.api.prescription.controller;

import com.remind.api.prescription.dto.request.CreatePrescriptionRequestDto;
import com.remind.api.prescription.dto.response.CreatePrescriptionResponseDto;
import com.remind.api.prescription.dto.response.PrescriptionInfoResponseDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Prescription(약 처방 정보) API", description = "prescription(처방 정보) API 문서")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    @Operation(
            summary = "의사가 약 처방 정보 생성 하는 api",
            description = "의사가 약 처방 정보 생성 하는 api"
    )
    @PostMapping("")
    public ResponseEntity<ApiSuccessResponse<CreatePrescriptionResponseDto>> createPrescription(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @Valid @RequestBody CreatePrescriptionRequestDto req) {
        return ResponseEntity.ok(new ApiSuccessResponse<>(prescriptionService.createPrescription(userDetails, req)));
    }

    @Operation(
            summary = "특정 환자의 현재 처방 정보를 조회하는 api",
            description = "특정 환자의 현재 처방 정보을 조회하는 api<br> 내 처방 정보를 조회하고 싶으면 memberId = 0<br>\n 오늘 해당되는 정보가 없으면 null "
    )
    @GetMapping("")
    public ResponseEntity<ApiSuccessResponse<PrescriptionInfoResponseDto>> getPrescriptionInfo(
            @AuthenticationPrincipal UserDetailsImpl userDetails,
            @RequestParam Long memberId) {
        return ResponseEntity.ok(new ApiSuccessResponse<>(prescriptionService.getPrescriptionInfo(userDetails,memberId)));
    }

}
