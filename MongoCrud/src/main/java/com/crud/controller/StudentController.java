package com.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.StudentRepository;

@RestController("/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentReository;
	
	
	@PostMapping("addstudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		Student save = this.studentReository.save(student);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("getstudents")
	public ResponseEntity<?> getStudents() {
		return ResponseEntity.ok(this.studentReository.findAll());
	}
	
	@PutMapping("updatestudent")
	public ResponseEntity<?> updateStudent(@RequestBody Student student) {
		Student save = this.studentReository.save(student);
		return ResponseEntity.ok(save);
		
	}
	
	@DeleteMapping("deletestudent/{Id}")
	public void deleteStudent(@PathVariable Integer Id) {
		this.studentReository.deleteById(Id);
	}
}
