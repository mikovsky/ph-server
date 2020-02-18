package com.michaldudek.phserver.controller;

import com.michaldudek.phserver.dao.services.RepositoryDaoService;
import com.michaldudek.phserver.dao.services.UserDaoService;
import com.michaldudek.phserver.model.User;
import com.michaldudek.phserver.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userDaoService.findAll());
    }

    @PostMapping("/{username}")
    public ResponseEntity<User> addUser(@PathVariable String username) {
        User user = githubService.getUserWithUsername(username);
        return ResponseEntity.ok(userDaoService.save(user));
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userDaoService.deleteByUsername(username);
        repositoryDaoService.deleteAllByOwnerUsername(username);
        return ResponseEntity.ok("Deleted");
    }

}
