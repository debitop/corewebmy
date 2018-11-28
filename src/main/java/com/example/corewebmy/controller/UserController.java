package com.example.corewebmy.controller;


import com.example.corewebmy.dto.UserDto;
import com.example.corewebmy.model.User;
import com.example.corewebmy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/user/add", consumes = APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody @Valid User user) {
        User saved = userRepository.save(user);
        return UserDto.UserDtoManager.toUserDto(saved);
    }

    @GetMapping(value = "/user/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<Long, User> getUsers() {
        return userRepository.get();
    }

}
