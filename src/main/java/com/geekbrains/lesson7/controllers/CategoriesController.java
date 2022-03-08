package com.geekbrains.lesson7.controllers;

import com.geekbrains.lesson7.entities.Categories;
import com.geekbrains.lesson7.entities.Product;
import com.geekbrains.lesson7.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
