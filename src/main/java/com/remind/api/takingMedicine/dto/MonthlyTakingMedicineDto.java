package com.remind.api.takingMedicine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "특정 월에서 일 단위의 약 복용 정보를 반환할 dto")
@Builder
public record
MonthlyTakingMedicineDto(

        @Schema(description = "약 복용이 필요한 날인지 여부")
        Boolean needMedicine,
        @Schema(description = "날짜(일 만)")
        int date,
        @Schema(description = "약을 복용한 횟수")
        int takingCount,
        @Schema(description = "약 복용 정도(0 : 미복용, 1 : 부분 복용, 2 : 모두 복용 완료")
        int takingLevel){


}
