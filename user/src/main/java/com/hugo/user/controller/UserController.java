package com.hugo.user.controller;


import com.hugo.user.model.User;
import com.hugo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }
}
