package com.sitionix.bffssox.mapper;

import com.app_afesox.bffssox.client.dto.UserDTO;
import com.app_afesox.bffssox.client.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserClientMapper {
    UserClientMapper INSTANCE = Mappers.getMapper(UserClientMapper.class);

    //User asUser(final UserResponseDTO responseUser);

    UserDTO asUserDto(final User user);

}
