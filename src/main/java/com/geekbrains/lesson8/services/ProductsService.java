package com.geekbrains.lesson8.services;

import com.geekbrains.lesson8.entities.Product;
import com.geekbrains.lesson8.repositories.ProductsRepository;
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

    public Product saveOrUpdate(Product product) {
       return productsRepository.save(product);
    }

    public Product getProductById(Long productId) {
        return productsRepository.findById(productId).get();
    }

    public void removeById(Long id) {
        productsRepository.deleteById(id);
    }
}
