package com.springboot.demo.web;

import com.springboot.demo.dao.UserRepository;
import com.springboot.demo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User get(@PathVariable  int id){
        return userRepository.findById(id).get();
    }

    public User create(@RequestBody User user){
        return userRepository.save(user);
    }


    public void update(@RequestBody User user){
        userRepository.save(user);
    }

    public void delete(@PathVariable  int id){
        userRepository.delete(userRepository.findById(id).get());
    }


    public void patch(@RequestBody User user , @PathVariable  int id){
        userRepository.save(user);
    }

}
