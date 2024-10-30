package com.spring.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.scheduler.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
