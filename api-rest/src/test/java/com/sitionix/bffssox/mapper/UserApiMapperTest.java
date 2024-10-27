package com.sitionix.bffssox.mapper;

import com.app_afesox.bffssox.api_first.dto.UserDTO;
import com.app_afesox.bffssox.api_first.dto.UserResponseDTO;
import com.sitionix.bffssox.domain.User;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.TestConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserApiMapperTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public UserApiMapper userApiMapper() {
            return new UserApiMapperImpl();
        }
    }

    @Autowired
    private UserApiMapper userApiMapper;

    @Test
    void givenUserDTO_whenAsUser_thenUser() {
        //given
        final UserDTO given = getUserDto();

        final User expected = getUser(null);

        //when
        final User actual = this.userApiMapper.asUser(given);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenUser_whenAsUserResponseDTO_thenUserResponseDTO() {
        //given
        final Long givenUserId = 1L;

        final User given = getUser(givenUserId);
        final UserResponseDTO expected = getUserResponseDto();

        //when
        final UserResponseDTO actual = this.userApiMapper.asUserResponseDTO(given);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    private User getUser(final Long id) {
        return User.builder()
                .id(id)
                .userName("username")
                .password("password")
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