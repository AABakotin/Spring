package com.geekbrains.lesson10.services;

import com.geekbrains.lesson10.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    List<User> findAll();
}
