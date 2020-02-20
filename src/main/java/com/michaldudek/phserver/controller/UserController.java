package com.michaldudek.phserver.controller;

import com.michaldudek.phserver.dao.services.RepositoryDaoService;
import com.michaldudek.phserver.dao.services.UserDaoService;
import com.michaldudek.phserver.model.User;
import com.michaldudek.phserver.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDaoService userDaoService;

    private final RepositoryDaoService repositoryDaoService;

    private final GithubService githubService;

    @Autowired
    public UserController(UserDaoService userDaoService, RepositoryDaoService repositoryDaoService, GithubService githubService) {
        this.userDaoService = userDaoService;
        this.repositoryDaoService = repositoryDaoService;
        this.githubService = githubService;
    }

    @GetMapping
    public ResponseEntity<Collection<User>> getAllUsers() {
        return ResponseEntity.ok(userDaoService.findAll());
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> addUser(@PathVariable String username) {
        User user = githubService.getUserWithUsername(username);
        User savedUser = userDaoService.save(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(format("User '%s' created", savedUser.getUsername()));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userDaoService.deleteByUsername(username);
        repositoryDaoService.deleteAllByOwnerUsername(username);
        return ResponseEntity.ok(format("User '%s' deleted", username));
    }

}
