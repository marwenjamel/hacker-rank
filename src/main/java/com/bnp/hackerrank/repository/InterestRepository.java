package com.bnp.hackerrank.repository;

import com.bnp.hackerrank.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterestRepository extends JpaRepository<Interest, InterestId> {

    List<Interest> findByName(String name);

}
