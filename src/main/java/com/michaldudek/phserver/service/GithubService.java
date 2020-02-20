package com.michaldudek.phserver.service;

import com.michaldudek.phserver.mapper.ModelMappers;
import com.michaldudek.phserver.model.Repository;
import com.michaldudek.phserver.model.User;
import com.michaldudek.phserver.payload.RepositoryPayload;
import com.michaldudek.phserver.payload.UserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

@Service
public class GithubService {

    private static final String BASE_URL = "https://api.github.com";

    private final RestTemplate restTemplate;

    private final ModelMappers modelMappers;

    @Autowired
    public GithubService(ModelMappers modelMappers, RestTemplateBuilder restTemplateBuilder, GithubErrorHandler githubErrorHandler) {
        this.modelMappers = modelMappers;
        this.restTemplate = restTemplateBuilder.errorHandler(githubErrorHandler).build();
    }

    public User getUserWithUsername(String username) {
        UserPayload userPayload = fetchUser(username).get();
        return modelMappers.mapUserPayloadToUser(userPayload);
    }

    public List<Repository> getUsersRepositories(String username) {
        List<RepositoryPayload> repositoriesPayload = fetchUsersRepositories(username);
        return modelMappers.mapRepositoriesPayloadToRepositories(repositoriesPayload);
    }

    private Optional<UserPayload> fetchUser(String username) {
        ResponseEntity<UserPayload> responseEntity = restTemplate.getForEntity(BASE_URL + "/users/" + username, UserPayload.class);
        return responseEntity.getStatusCode().is2xxSuccessful()
                ? ofNullable(responseEntity.getBody())
                : empty();
    }

    private List<RepositoryPayload> fetchUsersRepositories(String username) {
        RepositoryPayload[] repositoriesPayload = restTemplate.getForObject(BASE_URL + "/users/" + username + "/repos", RepositoryPayload[].class);
        return ofNullable(repositoriesPayload)
                .map(Arrays::asList)
                .orElse(emptyList());
    }

}
