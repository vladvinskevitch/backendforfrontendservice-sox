package com.sitionix.bffssox.client;

import com.app_afesox.bffssox.client.api.UserApi;
import com.app_afesox.bffssox.client.dto.UserDTO;
import com.app_afesox.bffssox.client.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import com.sitionix.bffssox.mapper.UserClientMapper;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AuthClientImplTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public AuthClientImpl authClient(final UserApi userApi,
                                         final UserClientMapper userClientMapper) {
            return new AuthClientImpl(userApi, userClientMapper);
        }
    }

    @Autowired
    private AuthClientImpl authClient;

    @MockBean
    private UserApi userApi;

    @MockBean
    private UserClientMapper userClientMapper;

    @Test
    void givenUser_whenCreateUser_thenReturnCreatedUser() {
        //given
        final User givenUser = Mockito.mock(User.class);
        final UserDTO userDTO = Mockito.mock(UserDTO.class);
        final UserResponseDTO createdUserDTO = Mockito.mock(UserResponseDTO.class);

        when(this.userClientMapper.asUserDto(givenUser)).thenReturn(userDTO);
        when(this.userApi.createUser(userDTO)).thenReturn(createdUserDTO);
        when(this.userClientMapper.asUser(createdUserDTO)).thenReturn(givenUser);

        //when
        final User actual = this.authClient.execute(givenUser);

        //then
        assertThat(actual).isEqualTo(givenUser);
    }

}