package com.wantedpreonboardingbackend.recruitmentnotice.dto;

import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecruitmentNoticeDetailResponseDto {
    private Long recruitmentNoticeId;
    private String companyName;
    private String country;
    private String region;
    private String recruitmentPosition;

    private BigDecimal recruitmentCompensation;

    private String stack;
    private String recruitmentDetails;
    private List<RecruitmentNoticeResponseDto> recruitmentNotices;
}
