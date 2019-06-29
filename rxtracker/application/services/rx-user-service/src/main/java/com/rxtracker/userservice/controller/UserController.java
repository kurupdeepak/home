package com.rxtracker.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rxtracker.userservice.entities.User;
import com.rxtracker.userservice.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired 
	UserService userService;
	
	@PostMapping("/users")
	public Long addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/users/{id}")	
	public Long updateUser(@PathVariable("id") Long userId,@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/users/{id}")
	public Long deleteUser(@PathVariable("id") Long userId) {
		return userService.deactivateUser(userId);
	}
	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/users")
	public List<User> allUsers() {
		return userService.getAllUsers();
	}
}
