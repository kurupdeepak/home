package com.rxtracker.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;
import com.rxtracker.userservice.dao.UserRepository;
import com.rxtracker.userservice.data.User;
import com.rxtracker.userservice.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	Mapper mapper;
	
	@Override
	public Long addUser(UserVO user) {
		User data = userRepository.save(mapper.map(user, User.class));
		return data.getUserId();
	}

	@Override
	public Long updateUser(UserVO user) {
		User existingUser = getUser(user.getUserId());
		if(existingUser == null)
			throw new UserNotFoundException("Unable to update " + user.getUserId());
		existingUser = userRepository.save(mapper.map(user, User.class));
		return existingUser.getUserId();
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
	public List<UserVO> getAllUsers() {
		List<User> results = userRepository.findAll();
		List<UserVO> destList = new ArrayList<>();
		results.stream().forEach(result -> destList.add(mapper.map(results, UserVO.class)));
		mapper.map(results,destList);
		return destList;
	}

}
