package com.wantedpreonboardingbackend.company.repository;

import com.wantedpreonboardingbackend.company.dto.CompanyResponseDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    private String country;

    private String region;

    public static CompanyResponseDto CompanyEntityToResponseDto(Company company){
        return CompanyResponseDto.builder()
                .companyId(company.getCompanyId())
                .country(company.getCountry())
                .region(company.getRegion())
                .build();
    }
}
