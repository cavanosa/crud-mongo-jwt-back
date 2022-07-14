package com.tutorial.crudmongoback.CRUD.entity;

import com.tutorial.crudmongoback.global.entity.EntityId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product extends EntityId {

    private String name;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
