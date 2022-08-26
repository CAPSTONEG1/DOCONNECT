package com.wipro.doconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.doconnect.dto.SignupRequest;
import com.wipro.doconnect.dto.UserDto;
import com.wipro.doconnect.entity.User;
import com.wipro.doconnect.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

   

    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User(signupRequest.getEmail(), new BCryptPasswordEncoder().encode(signupRequest.getPassword()), signupRequest.getName(), 2);
        user = userRepo.save(user);
        if (user == null)
            return  null;

        return user.mapUsertoUserDto();
    }

    public Boolean hasUserWithEmail(String email) {
        return userRepo.findFirstByEmail(email) != null;
    }
    
   
    @Override
    public void createAdminAccount() {
        User adminAccount = userRepo.findByRole(1);
        if(null == adminAccount) {
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            user.setName("Admin");
            user.setRole(1);
            userRepo.save(user);
        }
    }
}