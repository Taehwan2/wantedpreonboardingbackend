package com.wantedpreonboardingbackend.user.mapper;

import com.wantedpreonboardingbackend.user.dto.UserRequestDto;
import com.wantedpreonboardingbackend.user.dto.UserResponseDto;
import com.wantedpreonboardingbackend.user.repository.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userRequestDtoToUser(UserRequestDto userRequestDto);
    UserResponseDto userToUserResponseDto(User user);
}
