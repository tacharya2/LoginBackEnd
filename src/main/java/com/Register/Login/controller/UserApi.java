package com.Register.Login.controller;

import com.Register.Login.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public interface UserApi {

    @CrossOrigin(origins = "http://localhost:3000") // This is enough for CORS
    @PostMapping("/create")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto);
}