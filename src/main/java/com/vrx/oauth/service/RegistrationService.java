package com.vrx.oauth.service;

import com.vrx.oauth.dto.UserRegistrationDto;
import com.vrx.oauth.model.User;

public interface RegistrationService {

    public User registerUser(UserRegistrationDto user);
}
