package com.technobraintask.ecommerce_api.repository;

import com.technobraintask.ecommerce_api.models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_create_user() {
        //User user = new User(1L, "","","","","","");
        //userRepository.save(user);
    }

    @Test
    public void checkIfUserExists() {

    }


    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

}