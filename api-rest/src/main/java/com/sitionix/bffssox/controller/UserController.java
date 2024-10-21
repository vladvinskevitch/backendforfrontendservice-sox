package com.sitionix.bffssox.controller;

import com.app_afesox.bffssox.api_first.api.UserApi;
import com.app_afesox.bffssox.api_first.dto.UserDTO;
import com.app_afesox.bffssox.api_first.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import com.sitionix.bffssox.mapper.UserApiMapper;
import com.sitionix.bffssox.usecase.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserApiMapper userApiMapper;

    private final CreateUser createUser;

    @Override
    public ResponseEntity<UserResponseDTO> createUser(@Valid UserDTO userDTO) {

        final User user = this.userApiMapper.asUser(userDTO);
        final User createdUser = this.createUser.execute(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.userApiMapper.asUserResponseDTO(createdUser));
    }

}
