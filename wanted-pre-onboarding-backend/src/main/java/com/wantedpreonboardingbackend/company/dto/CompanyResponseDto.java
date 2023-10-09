package com.wantedpreonboardingbackend.company.dto;

import com.wantedpreonboardingbackend.company.repository.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDto {
    private Long companyId;

    private String companyName;

    private String country;

    private String region;


}
