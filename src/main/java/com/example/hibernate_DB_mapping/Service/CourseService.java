package com.example.hibernate_DB_mapping.Service;

import java.util.List;

import com.example.hibernate_DB_mapping.Entity.Course;

public interface CourseService {
	
	Course save(Course course);
	
	List<Course> findAll();
	
	Course findById(int id);
	
	void delete(int id);
	
	Course update (Course course);
	
	//Course addCourseToExistingInstructor(Course course);

}
