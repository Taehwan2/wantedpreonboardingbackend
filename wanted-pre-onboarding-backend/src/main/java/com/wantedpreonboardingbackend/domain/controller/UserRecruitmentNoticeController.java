package com.wantedpreonboardingbackend.domain.controller;

import com.wantedpreonboardingbackend.domain.service.UserRecruitmentNoticeServie;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import com.wantedpreonboardingbackend.recruitmentnotice.service.RecruitmentNoticeService;
import com.wantedpreonboardingbackend.response.Response;
import com.wantedpreonboardingbackend.user.mapper.UserMapper;
import com.wantedpreonboardingbackend.user.repository.User;
import com.wantedpreonboardingbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/userRecruitment")
public class UserRecruitmentNoticeController {
    private final UserRecruitmentNoticeServie userRecruitmentNoticeServie;
    private final UserMapper userMapper;
    @GetMapping("/{userId}/{recruitmentId}")
    public Response.SuccessResponse enroll(@PathVariable(name = "userId")Long userId,@PathVariable(name = "recruitmentId")Long recruitmentId){
        User user = userRecruitmentNoticeServie.enrollUserRecruitmentNotice(userId,recruitmentId);
        return  new Response.SuccessResponse(userMapper.userToUserResponseDto(user), HttpStatus.ACCEPTED);

    }


}
