package com.sitionix.bffssox.client;

import com.sitionix.bffssox.domain.User;

public interface AuthClient {

    User execute(final User user);
}
