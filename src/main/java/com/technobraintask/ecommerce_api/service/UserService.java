package com.technobraintask.ecommerce_api.service;

import com.technobraintask.ecommerce_api.dto.LoginDto;
import com.technobraintask.ecommerce_api.dto.RegisterDto;
import com.technobraintask.ecommerce_api.models.Role;
import com.technobraintask.ecommerce_api.models.RoleEnum;
import com.technobraintask.ecommerce_api.models.User;
import com.technobraintask.ecommerce_api.repository.RoleRepository;
import com.technobraintask.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // inject password encoder,user repository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthenticationManager authenticationManager;



    public User createUser(RegisterDto registerDto) {
        Optional<Role> roleOptional = roleRepository.findByName(RoleEnum.USER);
        if (roleOptional.isEmpty()) {
            return null;
        }


        User user = new User();
        user.setFullName(registerDto.getFullName());
        user.setEmail(registerDto.getEmail());
        user.setPhone(registerDto.getPhone());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(roleOptional.get());
       return userRepository.save(user);

    }

    public User loginUser(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()
        ));
        return userRepository.findUserByEmail(loginDto.getEmail()).orElseThrow();
    }

}
