package com.crackbyte.splitter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crackbyte.splitter.dto.UserDTO;
import com.crackbyte.splitter.entities.Address;
import com.crackbyte.splitter.entities.User;
import com.crackbyte.splitter.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@RequestParam Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user) {
        User newUser = new User(user);
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address(newUser));
        addresses.add(new Address(newUser));
        addresses.add(new Address(newUser));
        newUser.setAddresses(addresses);
        userService.addUser(newUser);
        return ResponseEntity.ok(new UserDTO(newUser));
    }

}
