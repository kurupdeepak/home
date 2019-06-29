package com.rxtracker.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rxtracker.userservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
