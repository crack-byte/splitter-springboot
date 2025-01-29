package com.crackbyte.splitter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crackbyte.splitter.entities.User;
import com.crackbyte.splitter.respository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
