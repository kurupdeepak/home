package com.rxtracker.userservice.service;

import java.util.List;

import com.rxtracker.userservice.data.User;
import com.rxtracker.userservice.vo.UserVO;

public interface UserService {
	
	Long updateUser(UserVO user);
	Long deleteUser(Long userId);
	Long deactivateUser(Long userId);
	User getUser(Long userId);
	List<UserVO> getAllUsers();
	Long addUser(UserVO user);
}
