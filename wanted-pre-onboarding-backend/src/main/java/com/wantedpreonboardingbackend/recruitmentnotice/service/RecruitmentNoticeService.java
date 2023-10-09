package com.wantedpreonboardingbackend.recruitmentnotice.service;

import com.wantedpreonboardingbackend.company.service.CompanyService;
import com.wantedpreonboardingbackend.error.BusinessLogicException;
import com.wantedpreonboardingbackend.error.ExceptionCode;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticePatchDto;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticeResponseDto;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNoticeRepository;
import com.wantedpreonboardingbackend.response.Pagination;
import com.wantedpreonboardingbackend.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Slf4j
public class RecruitmentNoticeService {

    private final RecruitmentNoticeRepository recruitmentNoticeRepository;
    private final CompanyService companyService;

    @Transactional
    public RecruitmentNotice enroll(Long companyId,RecruitmentNotice recruitmentNotice) {
        recruitmentNotice.setCompany(companyService.findByCompanyId(companyId));
        return recruitmentNoticeRepository.save(recruitmentNotice);
    }

    @Transactional
    public RecruitmentNotice enroll(RecruitmentNotice recruitmentNotice) {
        return recruitmentNoticeRepository.save(recruitmentNotice);
    }

    @Transactional(readOnly = true)
    public RecruitmentNotice getOne(Long recruitmentNoticeId) {
        return recruitmentNoticeRepository.findById(recruitmentNoticeId).orElseThrow(()->new BusinessLogicException(ExceptionCode.NOSUCHFOUND));
    }


    @Transactional(readOnly = true)
    public Response.API<List<RecruitmentNoticeResponseDto>> getAll(Pageable pageable) {
       var body =  recruitmentNoticeRepository.findAll(pageable);
        var page = convertPage(body);
        List<RecruitmentNotice> recruitmentNoticeList = body.getContent();
        List<RecruitmentNoticeResponseDto> recruitmentNoticeResponseDtoList = recruitmentNoticeList.stream()
                .map(a -> a.RecruitmentNoticeEntityToResponseDto(a))
                .collect(Collectors.toList());

       return Response.API.<List<RecruitmentNoticeResponseDto>>builder().body(recruitmentNoticeResponseDtoList).pagination(page).build();


    }

    @Transactional
    public void deleteOne(Long recruitmentNoticeId) {
        recruitmentNoticeRepository.deleteById(recruitmentNoticeId);
    }

    @Transactional(readOnly = true)
    public Response.API<List<RecruitmentNoticeResponseDto>> getOneByName(String name, Pageable pageable) {
        var body = recruitmentNoticeRepository.findAllByName(name,pageable);
        var page = convertPage(body);
        List<RecruitmentNotice> recruitmentNoticeList = body.getContent();
        List<RecruitmentNoticeResponseDto> recruitmentNoticeResponseDtoList = recruitmentNoticeList.stream()
                .map(a -> a.RecruitmentNoticeEntityToResponseDto(a))
                .collect(Collectors.toList());
        return Response.API.<List<RecruitmentNoticeResponseDto>>builder().body(recruitmentNoticeResponseDtoList).pagination(page).build();
    }

    public Pagination convertPage(Page body){
        return Pagination.builder().page(body.getNumber())
                .size(body.getSize())
                .currentElements(body.getNumberOfElements())
                .totalElements(body.getTotalElements())
                .totalPage(body.getTotalPages())
                .build();
    }
}
