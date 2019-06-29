package com.rxtracker.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxtracker.userservice.dao.UserRepository;
import com.rxtracker.userservice.entities.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserRepository userRepository;
	
	@Override
	public Long addUser(User user) {
		user = userRepository.save(user);
		return user.getUserId();
	}

	@Override
	public Long updateUser(User user) {
		User existingUser = getUser(user.getUserId());
		if(existingUser == null)
			throw new UserNotFoundException("Unable to update " + user.getUserId());
		user = userRepository.save(copyOf(user));
		return user.getUserId();
	}
	
	
	private User copyOf(User user) {
		User copy = new User();
		copy.setEmail(user.getEmail());
		copy.setFirst(user.getFirst());
		copy.setLast(user.getLast());
		copy.setPassword(user.getPassword());
		copy.setUserName(user.getUserName());
		copy.setUserId(user.getUserId());
		return copy;
	}

	@Override
	public Long deleteUser(Long userId) {
		User existingUser = getUser(userId);
		if(existingUser == null)
			throw new UserNotFoundException("Unable to delete :" + userId);
		userRepository.delete(userId);
		return userId;
	}

	@Override
	public Long deactivateUser(Long userId) {
		User user = getUser(userId);
		if(user == null)
			throw new UserNotFoundException("Unable to deactivate :" + userId);
		
		user = userRepository.save(user);
		return user.getUserId();	
	}

	@Override
	public User getUser(Long userId) {
		User user = userRepository.findOne(userId);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
