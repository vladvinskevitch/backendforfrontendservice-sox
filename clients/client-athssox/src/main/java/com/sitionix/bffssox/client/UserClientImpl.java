package com.sitionix.bffssox.client;

import com.app_afesox.athssox.client.api.UserApi;
import com.app_afesox.athssox.client.dto.UserDTO;
import com.app_afesox.athssox.client.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import com.sitionix.bffssox.mapper.UserClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserClientImpl implements UserClient {

    private final UserApi userApi;

    private final UserClientMapper userClientMapper;

    @Override
    public User createUser(final User user) {

        final UserDTO userDTO = this.userClientMapper.asUserDto(user);

        final UserResponseDTO createdUser = this.userApi.createUser(userDTO);

        return this.userClientMapper.asUser(createdUser);

    }
}
