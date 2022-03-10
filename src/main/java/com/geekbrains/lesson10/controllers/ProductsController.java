package com.geekbrains.lesson10.controllers;

import com.geekbrains.lesson10.entities.Product;
import com.geekbrains.lesson10.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/list")
    public String showProductsList(Model model) {
        List<Product> allProducts = productsService.getAllProductsList();
        model.addAttribute("productsList", allProducts);
        return "products-list";
    }



    @RequestMapping(path="/add", method=RequestMethod.GET)
    public String showAddForm(Model model) {
        Product product = new Product();
        product.setName("NameProduct");
        model.addAttribute("product", product);
        return "add-product-form";
    }

    @RequestMapping(path="/add", method=RequestMethod.POST)
    public String showAddForm(Product product) {
        productsService.addProduct(product);
        return "redirect:/products/list";
    }

    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long studentId) {
        productsService.removeById(studentId);
        return "redirect:/products/list";
    }

//    @RequestMapping(path="/add", method=RequestMethod.POST)
//    public String showAddForm(@RequestParam(value="student") Student student) {
//        studentsService.addStudent(student);
//        return "redirect:/students/list";
//    }
//
//    @RequestMapping("/processForm")
//    public String processForm(@ModelAttribute("student") Student student) {
//        System.out.println(student.getFirstName() + " " + student.getLastName());
//        return "student-form-result";
//    }
//
//    // http://localhost:8189/students/showStudentById?id=5
//    @RequestMapping(path="/showStudentById", method=RequestMethod.GET)
//    public String showStudentById(Model model, @RequestParam int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        model.addAttribute("student", student);
//        return "student-form-result";
//    }
//
//    @RequestMapping(path="/getStudentById", method=RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentById(@RequestParam int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        return student;
//    }
//
//    @RequestMapping(path="/getStudentById/{sid}", method=RequestMethod.GET)
//    @ResponseBody
//    public Student getStudentByIdFromPath(@PathVariable("sid") int id) {
//        Student student = studentsService.getStudentById(new Long(id));
//        return student;
//    }
}
