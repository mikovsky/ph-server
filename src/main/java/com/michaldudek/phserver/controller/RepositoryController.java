package com.michaldudek.phserver.controller;

import com.michaldudek.phserver.dao.services.RepositoryDaoService;
import com.michaldudek.phserver.model.Repository;
import com.michaldudek.phserver.service.GithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/repositories")
public class RepositoryController {

    private final RepositoryDaoService repositoryDaoService;

    private final GithubService githubService;

    @Autowired
    public RepositoryController(RepositoryDaoService repositoryDaoService, GithubService githubService) {
        this.repositoryDaoService = repositoryDaoService;
        this.githubService = githubService;
    }

    @GetMapping
    public ResponseEntity<Collection<Repository>> getAllRepositories() {
        return ResponseEntity.ok(repositoryDaoService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Collection<Repository>> getAllUsersRepositories(@PathVariable String username) {
        return ResponseEntity.ok(repositoryDaoService.findAllByOwnerUsername(username));
    }

    @GetMapping("/refresh/{username}")
    public ResponseEntity<String> refreshUsersRepositories(@PathVariable String username) {
        Collection<Repository> usersRepositories = githubService.getUsersRepositories(username);
        Collection<Repository> savedUsersRepositories = repositoryDaoService.saveAll(usersRepositories);
        return ResponseEntity.ok(savedUsersRepositories.size() + " repositories fetched and saved");
    }

}
