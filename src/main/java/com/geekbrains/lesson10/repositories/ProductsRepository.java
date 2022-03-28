package com.geekbrains.lesson10.repositories;

import com.geekbrains.lesson10.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
}
