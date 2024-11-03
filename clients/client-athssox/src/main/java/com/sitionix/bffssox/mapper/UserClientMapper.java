package com.sitionix.bffssox.mapper;

import com.app_afesox.athssox.client.dto.UserDTO;
import com.app_afesox.athssox.client.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserClientMapper {

    @Mapping(source = "username", target = "userName")
    User asUser(final UserResponseDTO responseUser);

    @Mapping(source = "userName", target = "username")
    UserDTO asUserDto(final User user);

}
