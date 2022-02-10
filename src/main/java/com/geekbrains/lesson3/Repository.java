package com.geekbrains.lesson3;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Repository {

    List<Product> productList;

    public Repository() {
        productList = new ArrayList<>();
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }


    public Product searchById(int id) {
        if (!(productList.isEmpty())) {
            for (Product product : productList) {
                if (product.getId() == (id)) {
                    return product;
                }
            }
        }
        return null;
    }

    public void deleteProduct(int id) {
        productList.remove(searchById(id));
    }
}


