package com.geriz.userservice.controller;

import com.geriz.userservice.VO.ResponseTemplateVO;
import com.geriz.userservice.entity.User;
import com.geriz.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser UserController");
        return userService.saveUser(user);
    }
    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId){
        log.info("Inside getUserWithDepartment UserController");
        return userService.getUserWithDepartment(userId);
    }
    @GetMapping("/")
    List<User> getUsers(User user){
        return userService.getUsers();
    }

}
