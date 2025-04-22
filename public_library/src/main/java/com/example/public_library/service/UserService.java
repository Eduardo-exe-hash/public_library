package com.example.public_library.service;

import com.example.public_library.model.User;
import com.example.public_library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
