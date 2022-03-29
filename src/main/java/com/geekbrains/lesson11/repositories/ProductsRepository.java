package com.geekbrains.lesson11.repositories;

import com.geekbrains.lesson11.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
    Product findOneByTitle(String title);
}
