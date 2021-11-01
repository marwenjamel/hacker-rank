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

import java.util.List;

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

    @Test
    public void should_fetch_interest_by_name() {
        //Given
        Interest interest = new Interest(new InterestId(CREDIT, EMEA, FRENCH), "Interest name");
        Interest interest1 = new Interest(new InterestId(CASH, APAC, FRENCH), "Interest name 1");
        Interest interest2 = new Interest(new InterestId(CREDIT, APAC, FRENCH), "Interest name 2");
        Interest interest3 = new Interest(new InterestId(CASH, EMEA, FRENCH), "Interest name 3");
        Interest interest4 = new Interest(new InterestId(CREDIT, EMEA, ENGLISH), "Interest name 4");
        Interest interest5 = new Interest(new InterestId(CASH, APAC, ENGLISH), "Interest name 5");
        Interest interest6 = new Interest(new InterestId(CREDIT, APAC, ENGLISH), "Interest name 6");
        Interest interest7 = new Interest(new InterestId(CASH, EMEA, ENGLISH), "Interest name 7");
        interestRepository.save(interest);
        interestRepository.save(interest1);
        interestRepository.save(interest2);
        interestRepository.save(interest3);
        interestRepository.save(interest4);
        interestRepository.save(interest5);
        interestRepository.save(interest6);
        interestRepository.save(interest7);
        //When
        List<Interest> interests = interestRepository.findByName("Interest name 6");
        //Then
        assertEquals(APAC, interests.get(0).getInterestId().getRegion());
    }
}
