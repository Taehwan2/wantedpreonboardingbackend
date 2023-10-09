package com.wantedpreonboardingbackend.domain.service;


import com.wantedpreonboardingbackend.error.BusinessLogicException;
import com.wantedpreonboardingbackend.error.ExceptionCode;
import com.wantedpreonboardingbackend.recruitmentnotice.repository.RecruitmentNotice;
import com.wantedpreonboardingbackend.recruitmentnotice.service.RecruitmentNoticeService;
import com.wantedpreonboardingbackend.user.repository.User;
import com.wantedpreonboardingbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRecruitmentNoticeServie {

    private final UserService userService;
    private final RecruitmentNoticeService recruitmentNoticeService;
    @Transactional()
    public User enrollUserRecruitmentNotice(Long userId, Long recruitmentId) {
        User user = userService.findById(userId);
        RecruitmentNotice recruitmentNotice = recruitmentNoticeService.getOne(recruitmentId);
        if(user.getRecruitmentNotice()==null){
            user.setRecruitmentNotice(recruitmentNotice);
            recruitmentNotice.setUsers(user);
        }
        else{
            throw new BusinessLogicException(ExceptionCode.ALREADYENROLL);
        }
        return userService.enroll(user);

    }
}
