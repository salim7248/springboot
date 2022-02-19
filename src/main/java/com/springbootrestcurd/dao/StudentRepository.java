package com.springbootrestcurd.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.springbootrestcurd.model.Student;

public interface StudentRepository extends JpaRepositoryImplementation<Student,Long> {

	

}
