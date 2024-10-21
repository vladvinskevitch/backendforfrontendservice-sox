package com.sitionix.bffssox.usecase;

import com.sitionix.bffssox.client.AuthClient;
import com.sitionix.bffssox.domain.User;

public class CreateUserImpl implements CreateUser {

    private AuthClient authClient;

    @Override
    public User execute(User user) {
        return this.authClient.execute(user);
    }
}
