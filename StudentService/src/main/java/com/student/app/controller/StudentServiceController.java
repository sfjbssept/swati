package com.student.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entity.Student;

@RestController
public class StudentServiceController {
	
	private static Map<String, List<Student>> schoolDB = new HashMap<String, List<Student>>();
	
	static {
		schoolDB = new HashMap<String, List<Student>>();
		
		List<Student> list = new ArrayList<Student>();
		
		Student std = new Student("Nishant", "Class11");
		list.add(std);
		
		schoolDB.put("School1", list);
	}
	
	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		
		System.out.println("Getting student details for " +schoolname);
		List<Student> studentList = schoolDB.get(schoolname);
		if(studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not found 404", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
}
