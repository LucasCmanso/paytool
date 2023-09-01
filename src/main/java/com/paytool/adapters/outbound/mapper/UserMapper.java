package com.paytool.adapters.outbound.mapper;

import com.paytool.adapters.outbound.dto.UserDto;
import com.paytool.adapters.outbound.dto.UserResponseDto;
import com.paytool.adapters.outbound.entity.UserEntity;
import com.paytool.application.core.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    @Mapping(target = "document", source="UserEntity.document")
    User userEntityToUser(UserEntity UserEntity);

    @Mapping(target = "document", source="user.document")
    UserResponseDto userToUserResponseDto(User user);

    @Mapping(target = "document", source="user.document")
    UserEntity userToUserEntity(User user);

    @Mapping(target = "document", source="userDto.document")
    User userDtoToUser(UserDto userDto);

    List<User> mapUserEntityListToUserList(List<UserEntity> userEntity);

    List<UserResponseDto> mapUserListToUserResponseDtoList(List<User> user);

}
