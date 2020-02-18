package com.michaldudek.phserver.dao.repositories;

import com.michaldudek.phserver.model.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface RepositoryRepository extends MongoRepository<Repository, Long> {
    void deleteAllByOwnerUsername(String username);
}
