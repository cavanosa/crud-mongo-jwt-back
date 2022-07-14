package com.tutorial.crudmongoback.CRUD.service;

import com.tutorial.crudmongoback.CRUD.dto.ProductDto;
import com.tutorial.crudmongoback.CRUD.entity.Product;
import com.tutorial.crudmongoback.CRUD.repository.ProductRepository;
import com.tutorial.crudmongoback.global.exceptions.AttributeException;
import com.tutorial.crudmongoback.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(int id) throws ResourceNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    public Product save(ProductDto dto) throws AttributeException {
        if(productRepository.existsByName(dto.getName()))
            throw new AttributeException("name already in use");
        int id = autoIncrement();
        Product product = new Product(id, dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(int id, ProductDto dto) throws ResourceNotFoundException, AttributeException {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));
        if(productRepository.existsByName(dto.getName()) && productRepository.findByName(dto.getName()).get().getId() != id)
            throw new AttributeException("name already in use");
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    public Product delete(int id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));;
        productRepository.delete(product);
        return product;
    }

    // private methods
    private int autoIncrement() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty()? 1 :
                products.stream().max(Comparator.comparing(Product::getId)).get().getId() + 1;
    }

}
