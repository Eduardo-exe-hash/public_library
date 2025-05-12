package com.example.public_library.controller;
import com.example.public_library.dto.MessageDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.example.public_library.dto.UserDTO;
import com.example.public_library.dto.UserLowDTO;
import com.example.public_library.model.User;
import com.example.public_library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping
    public UserLowDTO save(@RequestBody UserDTO user){
        return service.save(user);
    }
    @PutMapping("/{id}")
    public UserLowDTO update(@RequestBody UserDTO user){
        return service.save(user);
    }

    @Operation(summary = "Returns the user with the entered ID | role: [ADMIN]"
            ,tags = "User")
    @GetMapping("/resume")
    public List<UserLowDTO>findAll(){
        return service.findAll();
    }
    @Operation(summary = "Returns the user with the entered ID | role: [ADMIN]"
            ,tags = "User")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List user data"),
            @ApiResponse(responseCode = "404", description = "User Not Found!",
            content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        User user = service.findById(id);
        if (user != null){
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTO.setLogin(user.getLogin());
            userDTO.setPassword(user.getPassword());
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
    @GetMapping("/complete")
    public ResponseEntity<List<UserDTO>> listAll(){
        List<User> users = service.listAll();
        List<UserDTO> userDTOS = users.stream().map(user ->{
            UserDTO dto = new UserDTO();
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(userDTOS);
    }
}
