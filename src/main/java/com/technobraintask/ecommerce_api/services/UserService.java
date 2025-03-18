package com.technobraintask.ecommerce_api.services;

import com.technobraintask.ecommerce_api.models.User;
import com.technobraintask.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // inject password encoder,user repository
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);

    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
