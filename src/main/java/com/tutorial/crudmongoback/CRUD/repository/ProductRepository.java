package com.tutorial.crudmongoback.CRUD.repository;

import com.tutorial.crudmongoback.CRUD.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
    boolean existsByName(String name);
    Optional<Product> findByName(String name);
}
