package com.application.service;

import com.application.model.User;

import java.util.Optional;

public interface UserService {
     User creatUser (User user);
     Optional<User> getUserById (long Id);

}
