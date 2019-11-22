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
    UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable  int id){
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody User user,@PathVariable int id){
            user.setId(id);
            userService.update(user);
    }

    @PostMapping
    public int create(@RequestBody User user){
        return userService.create(user).getId();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id){
        userService.delete(id);
    }


    @PatchMapping("/{id}")
    public void patch(@RequestBody User user , @PathVariable  int id){
        userService.patch(user,id);
    }

}
