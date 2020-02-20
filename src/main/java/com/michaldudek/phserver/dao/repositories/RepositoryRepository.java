package com.michaldudek.phserver.dao.repositories;

import com.michaldudek.phserver.model.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface RepositoryRepository extends MongoRepository<Repository, Long> {
    Collection<Repository> findAllByOwnerUsername(String username);

    void deleteAllByOwnerUsername(String username);
}
