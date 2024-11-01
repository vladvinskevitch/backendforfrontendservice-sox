package com.sitionix.bffssox.usecase;

import com.sitionix.bffssox.client.UserClient;
import com.sitionix.bffssox.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserImpl implements CreateUser {

    private final UserClient userClient;

    @Override
    public User execute(final User user) {
        return this.userClient.createUser(user);
    }
}
