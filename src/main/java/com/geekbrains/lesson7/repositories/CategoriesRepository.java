package com.geekbrains.lesson7.repositories;

import com.geekbrains.lesson7.entities.Categories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends PagingAndSortingRepository <Categories, Long> {
}
