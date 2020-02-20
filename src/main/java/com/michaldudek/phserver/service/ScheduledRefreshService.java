package com.michaldudek.phserver.service;

import com.michaldudek.phserver.dao.services.RepositoryDaoService;
import com.michaldudek.phserver.dao.services.UserDaoService;
import com.michaldudek.phserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@Component
@Slf4j
public class ScheduledRefreshService {

    private final GithubService githubService;

    private final UserDaoService userDaoService;

    private final RepositoryDaoService repositoryDaoService;

    @Autowired
    public ScheduledRefreshService(GithubService githubService, UserDaoService userDaoService, RepositoryDaoService repositoryDaoService) {
        this.githubService = githubService;
        this.userDaoService = userDaoService;
        this.repositoryDaoService = repositoryDaoService;
    }

    @Scheduled(cron = "0 0/5 * * * *")
    public void fetchAllUsersRepositories() {
        log.info("Fetching repositories for all users in database");
        List<User> users = userDaoService.findAll();
        log.info(format("Found %d users", users.size()));
        users.stream()
                .map(User::getUsername)
                .map(githubService::getUsersRepositories)
                .forEach(repositoryDaoService::saveAll);
        log.info("Fetching repositories completed");
    }

}
