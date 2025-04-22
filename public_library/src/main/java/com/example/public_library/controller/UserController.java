package com.example.public_library.controller;

import com.example.public_library.model.User;
import com.example.public_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
