package com.geekbrains.lesson6.repository;


import com.geekbrains.lesson6.entities.Course;
import com.geekbrains.lesson6.entities.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentsRepository extends PagingAndSortingRepository<Student, Long> {


}
