package com.wantedpreonboardingbackend.company.repository;

import com.wantedpreonboardingbackend.company.dto.CompanyResponseDto;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    private String companyName;

    private String country;

    private String region;

    //디렉터리 삭제
    @OneToMany(mappedBy = "company")
    private List<RecruitmentNotice> recruitmentNotices=new ArrayList<>();

    public static CompanyResponseDto CompanyEntityToResponseDto(Company company){
        return CompanyResponseDto.builder()
                .companyName(company.getCompanyName())
                .companyId(company.getCompanyId())
                .country(company.getCountry())
                .region(company.getRegion())
                .build();
    }
}
