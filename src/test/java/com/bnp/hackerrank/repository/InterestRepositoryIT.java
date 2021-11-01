package com.bnp.hackerrank.repository;

import com.bnp.hackerrank.domain.Interest;
import com.bnp.hackerrank.domain.InterestId;
import com.bnp.hackerrank.domain.InterestLanguage;
import com.bnp.hackerrank.domain.InterestRegion;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import static com.bnp.hackerrank.domain.InterestLanguage.ENGLISH;
import static com.bnp.hackerrank.domain.InterestLanguage.FRENCH;
import static com.bnp.hackerrank.domain.InterestRegion.APAC;
import static com.bnp.hackerrank.domain.InterestRegion.EMEA;
import static com.bnp.hackerrank.domain.InterestType.CASH;
import static com.bnp.hackerrank.domain.InterestType.CREDIT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InterestRepositoryIT {
    @Autowired
    InterestRepository interestRepository;

    @Test
    public void should_create_interests() {
        //Given
        Interest interest = new Interest(new InterestId(CREDIT, EMEA, FRENCH), "Interest name");
        Interest interest1 = new Interest(new InterestId(CASH, APAC, ENGLISH), "Interest name 2");
        //When
        interestRepository.save(interest);
        interestRepository.save(interest1);
        //Then
        assertEquals(2, interestRepository.findAll().size());
    }

    @Test
    public void should_not_create_interest_when_interest_has_the_same_region_language_and_type() {
        //Given
        Interest interest = new Interest(new InterestId(CREDIT, EMEA, FRENCH), "Interest name");
        //When
        interestRepository.save(interest);
        interestRepository.save(interest);
        //Then
        assertEquals(1, interestRepository.findAll().size());
    }

    @Test
    public void should_not_create_interest_when_interest_exist_with_the_same_name() {
        //Given
        Interest interest = new Interest(new InterestId(CREDIT, EMEA, FRENCH), "Interest name");
        Interest interest1 = new Interest(new InterestId(CASH, APAC, ENGLISH), "Interest name");
        //When
        interestRepository.save(interest);
        //Then
        assertThrows(DataIntegrityViolationException.class, () -> {
            interestRepository.save(interest1);
            interestRepository.flush();
        });
    }
}
