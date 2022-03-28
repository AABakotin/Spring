package com.geekbrains.lesson10.controllers;

import com.geekbrains.lesson10.entities.Categories;
import com.geekbrains.lesson10.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/categories")
public class CategoriesController {

    CategoriesService categoriesService;

    @Autowired
    public void setCategoriesService(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @RequestMapping("/list")
    public String showAllCategory(Model model){
        List<Categories> allCategories = categoriesService.getAllCategories();
                model.addAttribute("categoryList", allCategories);
        return "categories-list";
    }

}
