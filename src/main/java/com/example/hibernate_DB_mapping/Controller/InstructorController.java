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

import com.example.hibernate_DB_mapping.Entity.Instructor;
import com.example.hibernate_DB_mapping.Service.InstructorService;

@RestController
@RequestMapping("/one2oneuni")
public class InstructorController {

	private InstructorService instructorService;
	
	@Autowired
	public InstructorController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}
	
	
	@PostMapping("/instructor")
	public Instructor saveInstructor(@RequestBody Instructor ins)
	{
		return instructorService.save(ins);
	}
	
	@GetMapping("/instructor")
	public List<Instructor> getInstructors()
	{
		return instructorService.findAll();
	}
	
	@GetMapping("/instructor/{id}")
	public Instructor getInstructor(@PathVariable int id)
	{
		return instructorService.findById(id);
	}
	
	@DeleteMapping("/instructor/{id}")
	public String deleteInstructor(@PathVariable int id)
	{
		instructorService.delete(id);
		return ("Instructor with id "+id+" is deleted.");
	}
	@PutMapping("/instructor")
	public Instructor updateInstructor(@RequestBody Instructor ins)
	{
		return instructorService.update(ins);
	}
	
	
	
}
