package com.geekbrains.lesson8.controllers;

import com.geekbrains.lesson8.entities.Product;
import com.geekbrains.lesson8.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market/**")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public List<Product> showProductsList() {
        return productsService.getAllProductsList();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productsService.getProductById(productId);

    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        product = productsService.saveOrUpdate(product);
        return product;
    }

    @PutMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@RequestBody Product product) {
        productsService.saveOrUpdate(product);
        return product;
    }

    @DeleteMapping("/products/{productId}")
    public int removeById(@PathVariable Long productId) {
        productsService.removeById(productId);
        return HttpStatus.OK.value();
    }

}
