package com.ecommerce.react.api.service;

import com.ecommerce.react.api.repository.AppUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private static Logger logger = LogManager.getLogger(UserService.class);

    private final AppUserRepository appUserRepository;

    @Autowired
    public UserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
}
