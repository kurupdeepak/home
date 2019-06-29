package com.rxtracker.userservice.service;

import java.util.List;

import com.rxtracker.userservice.entities.User;

public interface UserService {
	
	Long addUser(User user);
	Long updateUser(User user);
	Long deleteUser(Long userId);
	Long deactivateUser(Long userId);
	User getUser(Long userId);
	List<User> getAllUsers();
}
