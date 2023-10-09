package com.wantedpreonboardingbackend.recruitmentnotice.dto;

import com.wantedpreonboardingbackend.company.repository.Company;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentNoticeRequestDto {
    private Long companyId;

    private String recruitmentPosition;

    private BigDecimal recruitmentCompensation;

    private String recruitmentDetails;

    private String stack;
}
