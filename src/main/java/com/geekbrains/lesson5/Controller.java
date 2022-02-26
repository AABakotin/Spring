package com.geekbrains.lesson5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/product")
public class Controller {

    Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping("/add-one")
    public String addOne() {
        Product product = new Product();
        product.setId(1);
        product.setTitle("banana");
        product.setCost(120);
        service.addProduct(product);
        System.out.println(product.getTitle());
        return "index";
    }


    @RequestMapping("/add")
    public String addFormProduct(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/add-forms")
    public String addForms(@ModelAttribute("product") Product product) {
        service.addProduct(product);
        return "product-form-result";
    }

    @RequestMapping("/show-all")
    @ResponseBody
    public List<Product> showAllProduct() {
        return service.showListProduct();
    }

    @RequestMapping("/find-id/{sid}")
    @ResponseBody
    public Product showByIdProduct(@PathVariable("sid") int id) {
        return service.getById(id);
    }

    @RequestMapping("/delete-id/{sid}")
    @ResponseBody
    public List<Product> deleteProduct(@PathVariable("sid") int id) {
        service.deleteProduct(id);
        return showAllProduct();
    }

}
