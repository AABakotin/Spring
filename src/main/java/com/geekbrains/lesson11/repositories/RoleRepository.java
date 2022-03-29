package com.geekbrains.lesson11.repositories;

import com.geekbrains.lesson11.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String theRoleName);

	List<Role> findAll();

}
