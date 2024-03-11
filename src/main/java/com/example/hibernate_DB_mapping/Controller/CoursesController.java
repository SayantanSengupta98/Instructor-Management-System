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

import com.example.hibernate_DB_mapping.Entity.Course;
import com.example.hibernate_DB_mapping.Service.CourseService;

@RestController
@RequestMapping("/one2manybi")
public class CoursesController {
	
private CourseService courseService;
	
	@Autowired
	public CoursesController(CourseService courseService) {
		this.courseService = courseService;
	}
	
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course)
	{
		return courseService.save(course);
	}
	
	@DeleteMapping("/course/{id}")
	public String deleteCourse(@PathVariable int id)
	{
		courseService.delete(id);
		return ("Deleted Course with id "+id);
	}
	
	@GetMapping("/course")
	public List<Course> getCourses()
	{
		return courseService.findAll();
	}
	
	@GetMapping("/course/{id}")
	public Course getCourse(@PathVariable int id)
	{
		return courseService.findById(id);
	}
	
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course)
	{
		return courseService.update(course);
	}
}
