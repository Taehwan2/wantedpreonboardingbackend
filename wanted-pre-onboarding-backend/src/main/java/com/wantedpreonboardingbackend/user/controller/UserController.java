package com.wantedpreonboardingbackend.user.controller;

import com.wantedpreonboardingbackend.response.Response;
import com.wantedpreonboardingbackend.user.dto.UserRequestDto;
import com.wantedpreonboardingbackend.user.mapper.UserMapper;
import com.wantedpreonboardingbackend.user.repository.User;
import com.wantedpreonboardingbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @PostMapping("")
    public Response.SuccessResponse enrollUser(@RequestBody UserRequestDto userRequestDto){
        User user = userService.enroll(userMapper.userRequestDtoToUser(userRequestDto));
        return new Response.SuccessResponse(userMapper.userToUserResponseDto(user), HttpStatus.CREATED);
    }
}
