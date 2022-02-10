package com.geekbrains.lesson3;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private Repository repository;

    @Autowired
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public Product getById(int id) {
        return repository.searchById(id);
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    public List<Product> showListProduct() {
        return repository.getProductList();
    }


    public void deleteProduct(int id) {
        repository.deleteProduct(id);
    }
}
