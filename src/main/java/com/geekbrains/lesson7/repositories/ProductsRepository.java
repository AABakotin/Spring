package com.geekbrains.lesson7.repositories;

import com.geekbrains.lesson7.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
}
