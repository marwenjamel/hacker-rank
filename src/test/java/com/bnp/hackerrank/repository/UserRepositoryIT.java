package com.bnp.hackerrank.repository;

import com.bnp.hackerrank.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.bnp.hackerrank.domain.InterestLanguage.FRENCH;
import static com.bnp.hackerrank.domain.InterestRegion.APAC;
import static com.bnp.hackerrank.domain.InterestType.CASH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIT {

    @Autowired
    UserRepository userRepository;

    @Test
    public void should_create_users() {
        userRepository.save(new User());
        userRepository.save(new User());
        assertEquals(2, userRepository.findAll().size());
    }

    @Test
    public void should_create_interest_for_an_existing_user() {
        //Given
        User user = new User(Long.valueOf(1));
        userRepository.save(user);
        //When
        Interest interest = new Interest(new InterestId(CASH, APAC, FRENCH));
        user.setInterest(interest);
        userRepository.save(user);
        //Then
        assertNotNull(userRepository.findById(Long.valueOf(1)).get().getInterest());
    }
}
