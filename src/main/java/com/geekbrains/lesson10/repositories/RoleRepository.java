package com.geekbrains.lesson10.repositories;

import com.geekbrains.lesson10.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String theRoleName);

	List<Role> findAll();

}
