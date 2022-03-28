package com.geekbrains.lesson10.controllers;

import com.geekbrains.lesson10.entities.Role;
import com.geekbrains.lesson10.entities.User;
import com.geekbrains.lesson10.repositories.RoleRepository;
import com.geekbrains.lesson10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleRepository roleRepository;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("")
    public String adminHome(Model model) {
        List <User> AllUsers = userService.findAll();
        List<Role> AllRoles = roleRepository.findAll();
        model.addAttribute("rolesList", AllRoles);
        return "admin-panel";
    }
}
