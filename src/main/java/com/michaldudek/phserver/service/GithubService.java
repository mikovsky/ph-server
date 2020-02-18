package com.michaldudek.phserver.service;

import com.michaldudek.phserver.mapper.ModelMappers;
import com.michaldudek.phserver.model.Repository;
import com.michaldudek.phserver.model.User;
import com.michaldudek.phserver.payload.RepositoryPayload;
import com.michaldudek.phserver.payload.UserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Service
public class GithubService {

    private static final String BASE_URL = "https://api.github.com";

    private final RestTemplate restTemplate;

    private final ModelMappers modelMappers;

    @Autowired
    public GithubService(ModelMappers modelMappers) {
        this.modelMappers = modelMappers;
        this.restTemplate = new RestTemplate();
    }

    public User getUserWithUsername(String username) {
        UserPayload userPayload = fetchUser(username);
        return modelMappers.mapUserPayloadToUser(userPayload);
    }

    public List<Repository> getUsersRepositories(String username) {
        List<RepositoryPayload> repositoriesPayload = fetchUsersRepositories(username);
        return modelMappers.mapRepositoriesPayloadToRepositories(repositoriesPayload);
    }

    private UserPayload fetchUser(String username) {
        return restTemplate.getForObject(BASE_URL + "/users/" + username, UserPayload.class);
    }

    private List<RepositoryPayload> fetchUsersRepositories(String username) {
        RepositoryPayload[] repositoriesPayload = restTemplate.getForObject(BASE_URL + "/users/" + username + "/repos", RepositoryPayload[].class);
        return ofNullable(repositoriesPayload)
                .map(Arrays::asList)
                .orElse(emptyList());
    }

}
