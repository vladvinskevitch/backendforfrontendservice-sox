package com.sitionix.bffssox.mapper;

import com.app_afesox.bffssox.client.dto.UserDTO;
import com.app_afesox.bffssox.client.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserClientMapperTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserClientMapper userClientMapper() {
            return new UserClientMapperImpl();
        }
    }

    //    User asUser(final UserResponseDTO responseUser);
    //
    //    UserDTO asUserDto(final User user);

    @Autowired
    private UserClientMapper userClientMapper;


    @Test
    void givenUserResponseDTO_whenAsUser_thenRetunUser() {
        //given
        final String givenUserPassword = null;

        final UserResponseDTO given = this.getUserResponseDto();

        final User expected = this.getUser(givenUserPassword);
        //when

        final User actual = this.userClientMapper.asUser(given);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenUser_whenAsUserDto_thenReturnUserDTO() {
        //given
        final String givenUserPassword = "password";

        final User given = this.getUser(givenUserPassword);

        final UserDTO expected = this.getUserDto();

        //when

        final UserDTO actual = this.userClientMapper.asUserDto(given);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    private User getUser(final String password) {
        return User.builder()
                .id(1L)
                .userName("username")
                .password(password)
                .build();
    }

    private UserDTO getUserDto() {
        return new UserDTO()
                .password("password")
                .username("username");
    }

    private UserResponseDTO getUserResponseDto() {
        return new UserResponseDTO()
                .id(1L)
                .username("username");
    }

}