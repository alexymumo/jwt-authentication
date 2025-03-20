package com.technobraintask.ecommerce_api.services;

import com.technobraintask.ecommerce_api.dto.RegisterDto;
import com.technobraintask.ecommerce_api.models.User;
import com.technobraintask.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // inject password encoder,user repository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public User createUser(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPhone(registerDto.getPhone());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
       return userRepository.save(user);

    }

}
