package com.geekbrains.lesson8.controllers;

import com.geekbrains.lesson8.entities.Categories;
import com.geekbrains.lesson8.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/market/**")
public class CategoriesController {

    CategoriesService categoriesService;

    @Autowired
    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/categories")
    public List<Categories> showAllCategory(){
        return categoriesService.getAllCategories();
    }

}
