package com.bnp.hackerrank.repository;

import com.bnp.hackerrank.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIT {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_create_users() {
        userRepository.save(new User(Long.valueOf(1)));
        userRepository.save(new User(Long.valueOf(2)));
        assertEquals(2,userRepository.findAll().size());
    }
}
