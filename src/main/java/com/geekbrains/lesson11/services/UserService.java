package com.geekbrains.lesson11.services;

import com.geekbrains.lesson11.entities.SystemUser;
import com.geekbrains.lesson11.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    List<User> findAll();
    boolean save(SystemUser systemUser);
}
