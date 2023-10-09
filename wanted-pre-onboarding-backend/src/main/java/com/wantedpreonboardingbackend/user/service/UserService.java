package com.wantedpreonboardingbackend.user.service;

import com.wantedpreonboardingbackend.error.BusinessLogicException;
import com.wantedpreonboardingbackend.error.ExceptionCode;
import com.wantedpreonboardingbackend.user.repository.User;
import com.wantedpreonboardingbackend.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User enroll(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long userId) {
      return userRepository.findById(userId).orElseThrow(()->new BusinessLogicException(ExceptionCode.NOSUCHFOUND));
    }
}
