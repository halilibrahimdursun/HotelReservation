package com.application.service;

import com.application.model.User;
import com.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UseServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User creatUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }
}
