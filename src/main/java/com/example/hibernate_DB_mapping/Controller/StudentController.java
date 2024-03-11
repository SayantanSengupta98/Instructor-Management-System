package com.example.hibernate_DB_mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate_DB_mapping.Entity.Student;
import com.example.hibernate_DB_mapping.Service.StudentService;

@RestController
@RequestMapping("/many2many")
public class StudentController {

	StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student stud)
	{
		return studentService.save(stud);
	}
	
	@GetMapping("/student")
	public List<Student> getStudent()
	{
		return studentService.findAll();
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student stud)
	{
		return studentService.update(stud);
	}
	
	@DeleteMapping("/student/{id}")
	public String delStudent(@PathVariable int id)
	{
		studentService.delete(id);
		return ("Deleted Student with id " + id);
	}
}
