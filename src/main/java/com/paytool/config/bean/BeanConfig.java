package com.paytool.config.bean;

import com.paytool.application.core.service.UserService;
import com.paytool.application.ports.inbound.UserPort;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;

@Dependent
public class BeanConfig {

    @Default
    private UserService userService(UserPort userPort) {
        return new UserService(userPort);
    }
}
