package com.sitionix.bffssox.client;

import com.app_afesox.bffssox.client.api.UserApi;
import com.app_afesox.bffssox.client.dto.UserDTO;
import com.app_afesox.bffssox.client.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import com.sitionix.bffssox.mapper.UserClientMapper;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserClientImplTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserClient userClient(final UserApi userApi,
                                         final UserClientMapper userClientMapper) {
            return new UserClientImpl(userApi, userClientMapper);
        }
    }

    @Autowired
    private UserClient userClient;

    @MockBean
    private UserApi userApi;

    @MockBean
    private UserClientMapper userClientMapper;

    @AfterEach
    public void tearDown(){
        verifyNoMoreInteractions(
                this.userClientMapper,
                this.userApi
        );
    }

    @Test
    void givenUser_whenCreateUser_thenReturnCreatedUser() {

        //given
        final User givenUser = Mockito.mock(User.class);
        final UserDTO givenUserDTO = Mockito.mock(UserDTO.class);

        final UserResponseDTO createdUserDTO = Mockito.mock(UserResponseDTO.class);
        final User createdUser = Mockito.mock(User.class);

        when(this.userClientMapper.asUserDto(givenUser)).thenReturn(givenUserDTO);
        when(this.userClientMapper.asUser(createdUserDTO)).thenReturn(createdUser);
        when(this.userApi.createUser(givenUserDTO)).thenReturn(createdUserDTO);

        //when
        final User actual = this.userClient.createUser(givenUser);

        //then
        assertThat(actual).isEqualTo(createdUser);

        //verify
        verify(this.userClientMapper, times(1)).asUser(createdUserDTO);
        verify(this.userClientMapper, times(1)).asUserDto(givenUser);
        verify(this.userApi, times(1)).createUser(givenUserDTO);
    }

}