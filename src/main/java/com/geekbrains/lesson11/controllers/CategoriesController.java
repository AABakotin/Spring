package com.geekbrains.lesson11.controllers;

import com.geekbrains.lesson11.entities.Category;
import com.geekbrains.lesson11.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/categories")
public class CategoriesController {

    CategoryService categoriesService;

    @Autowired
    public void setCategoriesService(CategoryService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @RequestMapping("/list")
    public String showAllCategory(Model model){
        List<Category> allCategories = categoriesService.getAllCategories();
                model.addAttribute("categoryList", allCategories);
        return "categories-list";
    }

}
