package com.geekbrains.lesson11.repositories;

import com.geekbrains.lesson11.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends PagingAndSortingRepository <Category, Long> {
}
