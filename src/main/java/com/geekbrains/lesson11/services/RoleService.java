package com.geekbrains.lesson11.services;


import com.geekbrains.lesson11.entities.Role;
import com.geekbrains.lesson11.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }



    public List<Role> getAllRolers(){
        return roleRepository.findAll();
    }
}
