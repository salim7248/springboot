package com.springbootrestcurd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springbootrestcurd.Exception.StudentNotFoundException;
import com.springbootrestcurd.dao.StudentRepository;
import com.springbootrestcurd.model.Student;

import jakarta.transaction.Transactional;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student getstudentById(long id) {
		// TODO Auto-generated method stub
		Optional<Student> studData=studentRepository.findById(id) ;
		if(studData.isPresent()) {
		return studData.get();
		}
		else {
			throw new StudentNotFoundException("Student not present of id : "+id,HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Student update(long id, Student student) {
		// TODO Auto-generated method 
		Student stud=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException("Student not present of id : "+id,HttpStatus.NOT_FOUND));
		stud.setName(student.getName());
		stud.setCity(student.getCity());
		 studentRepository.save(stud); 
		 return stud;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}
	
	

	

}
