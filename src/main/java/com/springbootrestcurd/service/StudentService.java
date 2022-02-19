package com.springbootrestcurd.service;

import java.util.List;

import com.springbootrestcurd.model.Student;

public interface StudentService {

	public Student save(Student student);

	public List<Student> getAllStudent();

	public Student getstudentById(long id);

	public Student update(long id, Student student);

	public void delete(long id);

	
	
	

	
	

	 
	}


