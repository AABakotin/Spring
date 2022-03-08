package com.geekbrains.lesson7.services;

import com.geekbrains.lesson7.entities.Categories;
import com.geekbrains.lesson7.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {


    CategoriesRepository categoriesRepository;

    public CategoriesService() {

    }

    @Autowired
    public void setCategoriesRepository(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    public List<Categories> getAllCategories() {
        return (List<Categories>) categoriesRepository.findAll();
    }
}
