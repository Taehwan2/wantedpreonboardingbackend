package com.wantedpreonboardingbackend.recruitmentnotice.controller;

import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticePatchDto;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticeRequestDto;
import com.wantedpreonboardingbackend.recruitmentnotice.dto.RecruitmentNoticeResponseDto;
import com.wantedpreonboardingbackend.recruitmentnotice.mapper.RecruitmentNoticeMapper;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import com.wantedpreonboardingbackend.recruitmentnotice.service.RecruitmentNoticeService;
import com.wantedpreonboardingbackend.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/recruitmentNotice")
public class RecruitmentNoticeController {
    private final RecruitmentNoticeService recruitmentNoticeService;
    private final RecruitmentNoticeMapper recruitmentNoticeMapper;

    @PostMapping("/")
    public Response.SuccessResponse enrollRecruitmentNotice(@RequestBody RecruitmentNoticeRequestDto recruitmentNoticeRequestDto){
        log.info("what is {}",recruitmentNoticeRequestDto.getRecruitmentCompensation());
        RecruitmentNotice recruitmentNotice = recruitmentNoticeService.enroll(recruitmentNoticeRequestDto.getCompanyId(),recruitmentNoticeMapper.recruitmentNoticeRequestToEntity(recruitmentNoticeRequestDto));

        return  new Response.SuccessResponse(recruitmentNotice.RecruitmentNoticeEntityToResponseDto(recruitmentNotice), HttpStatus.CREATED);
    }


    @GetMapping("/one/{recruitmentNoticeId}")
    public Response.SuccessResponse getOneRecruitmentNotice(@PathVariable(name = "recruitmentNoticeId")Long recruitmentNoticeId){
        RecruitmentNotice recruitmentNotice = recruitmentNoticeService.getOne(recruitmentNoticeId);
        return  new Response.SuccessResponse(recruitmentNotice.RecruitmentNoticeEntityToResponseDto(recruitmentNotice), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getOneByCompanyName/{name}")
    public Response.SuccessResponse getOneRecruitmentNotice(@PageableDefault(sort = "recruitmentNoticeId",direction = Sort.Direction.DESC)Pageable pageable,@PathVariable(name = "name")String name){
        Response.API<List<RecruitmentNoticeResponseDto>> api = recruitmentNoticeService.getOneByName(name,pageable);
        return  new Response.SuccessResponse(api, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getOneDetail/{recruitmentNoticeId}")
    public Response.SuccessResponse getOneDetailRecruitmentNotice(@PathVariable(name = "recruitmentNoticeId")Long recruitmentNoticeId){
        RecruitmentNotice recruitmentNotice = recruitmentNoticeService.getOne(recruitmentNoticeId);
        return  new Response.SuccessResponse(recruitmentNotice.RecruitmentNoticeEntityToDetailResponseDto(recruitmentNotice), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public Response.SuccessResponse getALlRecruitmentNotice(@PageableDefault(sort = "recruitmentNoticeId",direction = Sort.Direction.DESC) Pageable pageable){
       Response.API<List<RecruitmentNoticeResponseDto>> listAPI = recruitmentNoticeService.getAll(pageable);
        return  new Response.SuccessResponse(listAPI, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/update/{recruitmentNoticeId}")
    public Response.SuccessResponse patchRecruitmentNotice(@PathVariable(name ="recruitmentNoticeId") Long recruitmentNoticeId, @RequestBody RecruitmentNoticePatchDto recruitmentNoticePatchDto){
       RecruitmentNotice recruitmentNotice= recruitmentNoticeService.getOne(recruitmentNoticeId);
       recruitmentNoticeMapper.recruitmentNoticePatchDtoToEntity(recruitmentNoticePatchDto,recruitmentNotice);
        recruitmentNotice = recruitmentNoticeService.enroll(recruitmentNotice);
       return new Response.SuccessResponse(recruitmentNotice.RecruitmentNoticeEntityToResponseDto(recruitmentNotice),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{recruitmentNoticeId}")
    public HttpStatus deleteOne(@PathVariable(name = "recruitmentNoticeId")Long recruitmentNoticeId){
        recruitmentNoticeService.deleteOne(recruitmentNoticeId);
        return HttpStatus.ACCEPTED;
    }
}
