package com.geekbrains.lesson6.repository;


import com.geekbrains.lesson6.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends CrudRepository<Student, Long> {

}
