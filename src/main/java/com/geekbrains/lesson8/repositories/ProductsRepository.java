package com.geekbrains.lesson8.repositories;

import com.geekbrains.lesson8.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
}
