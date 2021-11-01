package com.bnp.hackerrank.repository;

import com.bnp.hackerrank.domain.Interest;
import com.bnp.hackerrank.domain.InterestId;
import com.bnp.hackerrank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<Interest, InterestId> {
}
