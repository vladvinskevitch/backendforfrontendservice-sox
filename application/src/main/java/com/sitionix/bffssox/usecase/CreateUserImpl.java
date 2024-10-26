package com.sitionix.bffssox.usecase;

import com.sitionix.bffssox.client.AuthClient;
import com.sitionix.bffssox.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserImpl implements CreateUser {

    private final AuthClient authClient;

    @Override
    public User execute(User user) {
        return this.authClient.execute(user);
    }
}
