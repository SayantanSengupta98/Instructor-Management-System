package com.example.hibernate_DB_mapping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate_DB_mapping.Entity.Course;
import com.example.hibernate_DB_mapping.Entity.Instructor;
import com.example.hibernate_DB_mapping.Repository.CourseRepository;
import com.example.hibernate_DB_mapping.Repository.InstructorRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	private CourseRepository courseRepository;
	private InstructorRepository instructorRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, InstructorRepository instructorRepository) {
		this.courseRepository = courseRepository;
		this.instructorRepository = instructorRepository;
	}
	

	/*Save a new course
	 *  - without any instructor
	 *  - save course to an existing Instructor
	 * 	- create new Instructor and save course to it
	 * 	
	 */
	
	@Override
	public Course save(Course course) {
		course.setId(0);
		if(course.getInstructor()!=null)
		{
			Optional<Instructor> result = instructorRepository.findById(course.getInstructor().getId());
			if(result.isPresent())
			{
				Instructor tempIns = result.get();
				course.setInstructor(tempIns);
				tempIns.getCourses().add(course);
			}
			else
			{
				course.getInstructor().setId(0);
				course.getInstructor().getCourses().add(course);
			}
		}
		return courseRepository.save(course);
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		Optional<Course> result = courseRepository.findById(id);
		if(result.isPresent())
		{
			//System.out.println(result.get().getStudents());
			return result.get();
			}
		else
			throw new RuntimeException("Course Not found with id "+id); 
	}

	@Override
	public void delete(int id) {
		
		courseRepository.deleteById(id);

	}
	
	/*update a existing course into an existing Instructor
	 * 
	 *Change the Instructor of the course
	 */
	@Override
	public Course update(Course course) {
		Course c = findById(course.getId());
		if(course.getInstructor()!= null)
		{
			int instructorId = course.getInstructor().getId();
			Instructor i = new Instructor();
			Optional<Instructor> temp = instructorRepository.findById(instructorId);
			if(temp.isPresent())
				i = temp.get();
			else
				throw new RuntimeException("Instructor Not found with id "+instructorId);
			
			course.setInstructor(i);
		}
		else
		{
			int instructorId = c.getInstructor().getId();
			Instructor i = new Instructor();
			Optional<Instructor> temp = instructorRepository.findById(instructorId);
			if(temp.isPresent())
				i = temp.get();
			else
				throw new RuntimeException("Instructor Not found with id "+instructorId);
			
			course.setInstructor(i);
		}
		return courseRepository.save(course);
	}



}
