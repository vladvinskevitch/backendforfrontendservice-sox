package com.sitionix.bffssox.usecase;

import com.sitionix.bffssox.domain.User;

public interface CreateUser {

    User execute(final User user);
}
