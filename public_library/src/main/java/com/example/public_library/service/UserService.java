package com.example.public_library.service;

import com.example.public_library.dto.UserDTO;
import com.example.public_library.dto.UserLowDTO;
import com.example.public_library.model.User;
import com.example.public_library.repository.UserRepository;
import com.example.public_library.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserLowDTO save(UserDTO user){
        var userEntity = MapperUtil.parseObject(user,User.class);
        var userSaved = userRepository.save(userEntity);
        return MapperUtil.parseObject(userSaved, UserLowDTO.class);
    }
    public List<UserLowDTO> findAll(){
        var listUsers = userRepository.findAll();
        return MapperUtil.parseListObjects(listUsers,UserLowDTO.class);
    }
    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public List<User> listAll(){
        return userRepository.findAll();
    }
}
