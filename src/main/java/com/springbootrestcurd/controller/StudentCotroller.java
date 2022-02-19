package com.springbootrestcurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestcurd.model.Student;
import com.springbootrestcurd.service.StudentService;

@RestController
//@RequestMapping("/api")
public class StudentCotroller {
	
@Autowired	
private StudentService studentservice;

@PostMapping("/student")
public ResponseEntity<Student> save(@RequestBody Student student)
{
Student stud=studentservice.save(student);
return new ResponseEntity<Student>(stud,HttpStatus.CREATED);
  
}
@GetMapping("/students")
public List<Student> getAllStudent(){
return studentservice.getAllStudent();	
	
}
@GetMapping("/students/{id}")
public ResponseEntity studentById(@PathVariable("id") long id) {
	Student stud=studentservice.getstudentById(id);
	return new ResponseEntity<Student>(stud,HttpStatus.OK);
	
}
@PutMapping("/students/{id}")
public ResponseEntity<Student> update(@PathVariable("id") long id,@RequestBody Student student){
	Student stud=studentservice.update(id,student);
	return new  ResponseEntity<Student>(stud,HttpStatus.OK) ;
	
}
@DeleteMapping("/students/{id}")
public ResponseEntity<String> deleteStudentById(@PathVariable("id") long id){
	studentservice.delete(id);
	return ResponseEntity.ok().body("Record delete successfully");
}
	
}


