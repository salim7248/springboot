package com.springbootrestcurd.Exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends RuntimeException{
	String msg;

	public StudentNotFoundException(String msg,HttpStatus notFound) {
		super(msg);
		this.msg = msg;
	}

}
