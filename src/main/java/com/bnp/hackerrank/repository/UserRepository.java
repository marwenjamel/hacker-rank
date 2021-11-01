package com.bnp.hackerrank.repository;


import com.bnp.hackerrank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
