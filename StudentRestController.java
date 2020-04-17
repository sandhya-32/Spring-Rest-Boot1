package com.capgemini.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springdemo.rest.StudentErrorResponse;
import com.capgemini.springdemo.rest.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudent;

	// define @postConstructor to the student data
	@PostConstruct
	public void loadData() {
		theStudent = new ArrayList<>();
		theStudent.add(new Student("sandhya", "sukanya"));
		theStudent.add(new Student("narendra", "suresh"));
		theStudent.add(new Student("manikanta", "kusuma"));
		theStudent.add(new Student("sasi", "venkat"));
		theStudent.add(new Student("gopi", "mahesh"));
	}

	// define end point for "/student"
	@GetMapping("/Students")
	public List<Student> getStudents() {
		List<Student> theStudent = new ArrayList<>();

		return theStudent;
	}

	// define endpoint fot students/{studentid}
	@GetMapping("/Students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if ((studentId >= theStudent.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Studentid not found - " + studentId);
		}
		return theStudent.get(studentId);
	}
	//add an exception handler method using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
			//create a StudentErrorResponse
			StudentErrorResponse error= new StudentErrorResponse();
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			//return ResponseEntity
			return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
		//add another exception handler
		@ExceptionHandler
		public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
			
			//create a StudentErrorResponse
			StudentErrorResponse error= new StudentErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			//return ResponseEntity
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
					
		
		}

}