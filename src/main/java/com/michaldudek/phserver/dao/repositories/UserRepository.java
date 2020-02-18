package com.michaldudek.phserver.dao.repositories;

import com.michaldudek.phserver.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    void deleteByUsername(String username);
}
