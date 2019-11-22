package com.springboot.demo.web;

import com.springboot.demo.dao.UserRepository;
import com.springboot.demo.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public User get(@PathVariable  int id){
            return userRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user){
        userRepository.save(user);
    }

    @PostMapping
    public void create(@RequestBody User user){
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id){
        userRepository.delete(userRepository.findById(id).get());
    }


    @PatchMapping("/{id}")
    public void patch(@RequestBody User user , @PathVariable  int id){
        userRepository.save(user);
    }

}
