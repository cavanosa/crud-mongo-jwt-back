package com.tutorial.crudmongoback.security.repository;

import com.tutorial.crudmongoback.security.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
