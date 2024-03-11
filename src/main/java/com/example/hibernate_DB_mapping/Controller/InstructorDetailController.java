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

import com.example.hibernate_DB_mapping.Entity.InstructorDetail;
import com.example.hibernate_DB_mapping.Service.InstructorDetailService;

@RestController
@RequestMapping("/one2onebi")
public class InstructorDetailController {
private InstructorDetailService instructorDetailService;
	
	@Autowired
	public InstructorDetailController(InstructorDetailService instructorDetailService) {
		this.instructorDetailService = instructorDetailService;
	}
	
	
	@PostMapping("/instructordetail")
	public InstructorDetail saveInstructor(@RequestBody InstructorDetail ins)
	{
		return instructorDetailService.save(ins);
	}
	
	@GetMapping("/instructordetail")
	public List<InstructorDetail> getInstructors()
	{
		return instructorDetailService.findAll();
	}
	
	@GetMapping("/instructordetail/{id}")
	public InstructorDetail getInstructor(@PathVariable int id)
	{
		return instructorDetailService.findById(id);
	}
	
	@DeleteMapping("/instructordetail/{id}")
	public String deleteInstructor(@PathVariable int id)
	{
		instructorDetailService.delete(id);
		return ("Instructor Details with id "+id+" is deleted.");
	}
	@PutMapping("/instructordetail")
	public InstructorDetail updateInstructor(@RequestBody InstructorDetail ins)
	{
		return instructorDetailService.update(ins);
	}

}
