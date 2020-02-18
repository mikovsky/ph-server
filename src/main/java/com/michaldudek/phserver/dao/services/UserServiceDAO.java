package com.michaldudek.phserver.dao.services;

import com.michaldudek.phserver.dao.repositories.UserRepository;
import com.michaldudek.phserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDAO {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}
