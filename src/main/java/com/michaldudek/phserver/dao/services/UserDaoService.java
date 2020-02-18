package com.michaldudek.phserver.dao.services;

import com.michaldudek.phserver.dao.repositories.UserRepository;
import com.michaldudek.phserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {

    private final UserRepository userRepository;

    @Autowired
    public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}
