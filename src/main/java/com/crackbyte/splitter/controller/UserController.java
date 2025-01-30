package com.crackbyte.splitter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crackbyte.splitter.dto.UserDTO;
import com.crackbyte.splitter.entities.User;
import com.crackbyte.splitter.service.UserService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers().stream().map(UserDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDto) {
        log.info("Adding user: {}", userDto);
        User newUser = new User(userDto);
        userService.addUser(newUser);
        log.info("Added user Successfully");
        return ResponseEntity.ok(new UserDTO(newUser));
    }

}
