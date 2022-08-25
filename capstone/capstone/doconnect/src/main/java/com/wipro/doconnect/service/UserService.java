package com.wipro.doconnect.service;

import com.wipro.doconnect.dto.SignupRequest;
import com.wipro.doconnect.dto.UserDto;

public interface UserService {

    void createAdminAccount();

    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}

