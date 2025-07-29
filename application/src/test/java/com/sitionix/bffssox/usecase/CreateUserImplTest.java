package com.sitionix.bffssox.usecase;


import com.sitionix.bffssox.client.UserClient;
import com.sitionix.bffssox.domain.User;
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
class CreateUserImplTest {

    @TestConfiguration
    static class TestContextConfiguration {
        @Bean
        public CreateUser createUser(final UserClient authClient) {
            return new CreateUserImpl(authClient);
        }
    }

    @Autowired
    private CreateUser createUser;

    @MockBean
    private UserClient userClient;

    @AfterEach
    public void tearDown() {
        verifyNoMoreInteractions(
                this.userClient
        );
    }

    @Test
    void givenUser_whenCreateUser_thenReturnCreatedUser() {
        //given
        final User given = Mockito.mock(User.class);
        final User createdUser = Mockito.mock(User.class);

        when(this.userClient.createUser(given)).thenReturn(createdUser);

        //when
        final User actual = this.createUser.execute(given);

        //then
        assertThat(actual).isEqualTo(createdUser);

        //verify
        verify(this.userClient, times(1)).createUser(given);
    }

}