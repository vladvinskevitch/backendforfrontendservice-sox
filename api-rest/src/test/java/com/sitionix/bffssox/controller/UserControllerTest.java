package com.sitionix.bffssox.controller;

import com.app_afesox.bffssox.api_first.dto.UserDTO;
import com.app_afesox.bffssox.api_first.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import com.sitionix.bffssox.mapper.UserApiMapper;
import com.sitionix.bffssox.usecase.CreateUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserControllerTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserController userController(final UserApiMapper userApiMapper, final CreateUser createUser) {
            return new UserController(userApiMapper, createUser);
        }
    }

    @Autowired
    private UserController userController;

    @MockBean
    private UserApiMapper userApiMapper;

    @MockBean
    private CreateUser createUser;

    @AfterEach
    public void tearDown() {
        verifyNoMoreInteractions(
                this.userApiMapper,
                this.createUser
        );
    }

    @Test
    void givenUserDTO_whenCreateUser_thenReturnUserResponseDTO() {
        //given
        final UserDTO given = Mockito.mock(UserDTO.class);
        final User user = Mockito.mock(User.class);
        final UserResponseDTO expectedUser = Mockito.mock(UserResponseDTO.class);

        final ResponseEntity<UserResponseDTO> expectedResponse = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(expectedUser);

        when(this.userApiMapper.asUser(given)).thenReturn(user);
        when(this.userApiMapper.asUserResponseDTO(user)).thenReturn(expectedUser);
        when(this.createUser.execute(user)).thenReturn(user);

        //when
        final ResponseEntity<UserResponseDTO> actual = this.userController.createUser(given);

        //then
        assertThat(actual).isEqualTo(expectedResponse);

        //verify
        verify(this.userApiMapper, times(1)).asUser(given);
        verify(this.userApiMapper, times(1)).asUserResponseDTO(user);
        verify(this.createUser, times(1)).execute(user);
    }

}