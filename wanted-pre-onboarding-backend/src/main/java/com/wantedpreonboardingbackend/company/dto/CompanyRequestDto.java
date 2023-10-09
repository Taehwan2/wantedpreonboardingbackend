package com.wantedpreonboardingbackend.company.dto;

import com.wantedpreonboardingbackend.company.repository.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyRequestDto {

    private String companyName;
    private String country;

    private String region;

    public static Company CompanyDtoToEntity(CompanyRequestDto companyRequestDto){
        return Company.builder()
                .companyName(companyRequestDto.getCompanyName())
                .country(companyRequestDto.getCountry())
                .region(companyRequestDto.getRegion())
                .build();
    }
}
