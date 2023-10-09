package com.wantedpreonboardingbackend.recruitmentnotice.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentNoticePatchDto {
    private String recruitmentPosition;

    private BigDecimal recruitmentCompensation;

    private String recruitmentDetails;

    private String stack;
}
