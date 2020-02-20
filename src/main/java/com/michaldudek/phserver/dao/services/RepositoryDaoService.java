package com.michaldudek.phserver.dao.services;

import com.michaldudek.phserver.dao.repositories.RepositoryRepository;
import com.michaldudek.phserver.model.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RepositoryDaoService {

    private final RepositoryRepository repositoryRepository;

    @Autowired
    public RepositoryDaoService(RepositoryRepository repositoryRepository) {
        this.repositoryRepository = repositoryRepository;
    }

    public Collection<Repository> findAll() {
        return repositoryRepository.findAll();
    }

    public Collection<Repository> findAllByOwnerUsername(String username) {
        return repositoryRepository.findAllByOwnerUsername(username);
    }

    public Repository save(Repository repository) {
        return repositoryRepository.save(repository);
    }

    public Collection<Repository> saveAll(Collection<Repository> repositories) {
        return repositoryRepository.saveAll(repositories);
    }

    public void deleteAllByOwnerUsername(String username) {
        repositoryRepository.deleteAllByOwnerUsername(username);
    }

}
