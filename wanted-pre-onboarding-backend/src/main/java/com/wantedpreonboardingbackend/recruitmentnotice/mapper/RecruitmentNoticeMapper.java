package com.wantedpreonboardingbackend.recruitmentnotice.mapper;

import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticePatchDto;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticeRequestDto;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RecruitmentNoticeMapper {
    RecruitmentNotice recruitmentNoticeRequestToEntity(RecruitmentNoticeRequestDto recruitmentNoticeRequestDto);

    void recruitmentNoticePatchDtoToEntity(RecruitmentNoticePatchDto recruitmentNoticePatchDto, @MappingTarget RecruitmentNotice recruitmentNotice);
}
