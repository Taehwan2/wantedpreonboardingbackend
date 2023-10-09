package com.wantedpreonboardingbackend.recruitmentnotice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentNoticeResponseDto {
    private Long recruitmentNoticeId;
    private String companyName;
    private String country;
    private String region;
    private String recruitmentPosition;

    private BigDecimal recruitmentCompensation;

    private String stack;

}
