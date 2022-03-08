package com.geekbrains.lesson8.repositories;

import com.geekbrains.lesson8.entities.Categories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriesRepository extends PagingAndSortingRepository <Categories, Long> {
}
