package com.wantedpreonboardingbackend.recruitmentnotice.repository;

import com.wantedpreonboardingbackend.company.dto.CompanyResponseDto;
import com.wantedpreonboardingbackend.company.repository.Company;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticeDetailResponseDto;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticeResponseDto;
import com.wantedpreonboardingbackend.user.repository.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "recruitment_notice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class RecruitmentNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitmentNoticeId;

    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;

    private String recruitmentPosition;

    private BigDecimal recruitmentCompensation;

    private String recruitmentDetails;

    private String stack;
    @OneToMany(mappedBy = "userId")
   private List<User> users;

    public void setUsers(User user){
        this.users.add(user);
    }

    public static RecruitmentNoticeResponseDto RecruitmentNoticeEntityToResponseDto(RecruitmentNotice recruitmentNotice){
        return RecruitmentNoticeResponseDto.builder()
                .recruitmentNoticeId(recruitmentNotice.getRecruitmentNoticeId())
                .recruitmentCompensation(recruitmentNotice.getRecruitmentCompensation())
                .recruitmentPosition(recruitmentNotice.getRecruitmentPosition())
                .stack(recruitmentNotice.getStack())
                .companyName(recruitmentNotice.getCompany().getCompanyName())
                .region(recruitmentNotice.getCompany().getRegion())
                .country(recruitmentNotice.getCompany().getCountry())
                .build();
    }
    public static RecruitmentNoticeDetailResponseDto RecruitmentNoticeEntityToDetailResponseDto(RecruitmentNotice recruitmentNotice){
        List<RecruitmentNoticeResponseDto> recruitmentNoticeResponseDtoList = recruitmentNotice.getCompany().getRecruitmentNotices().stream()
                .map(a->a.RecruitmentNoticeEntityToResponseDto(a)).collect(Collectors.toList());
        return RecruitmentNoticeDetailResponseDto.builder()
                .recruitmentNoticeId(recruitmentNotice.getRecruitmentNoticeId())
                .recruitmentCompensation(recruitmentNotice.getRecruitmentCompensation())
                .recruitmentPosition(recruitmentNotice.getRecruitmentPosition())
                .stack(recruitmentNotice.getStack())
                .companyName(recruitmentNotice.getCompany().getCompanyName())
                .region(recruitmentNotice.getCompany().getRegion())
                .country(recruitmentNotice.getCompany().getCountry())
                .recruitmentDetails(recruitmentNotice.getRecruitmentDetails())
                .recruitmentNotices(recruitmentNoticeResponseDtoList)
                .build();
    }

}
