package com.geekbrains.lesson7.services;

import com.geekbrains.lesson7.entities.Product;
import com.geekbrains.lesson7.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public ProductsService() {
    }

    public List<Product> getAllProductsList() {
        return (List<Product>) productsRepository.findAll();
    }

    public void addProduct(Product s) {
        productsRepository.save(s);
    }

    public void removeById(Long id) {
        productsRepository.deleteById(id);
    }
}
