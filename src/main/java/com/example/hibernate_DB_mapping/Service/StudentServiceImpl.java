package com.example.hibernate_DB_mapping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate_DB_mapping.Entity.Course;
import com.example.hibernate_DB_mapping.Entity.Student;
import com.example.hibernate_DB_mapping.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	StudentRepository studentRepository;
	CourseService courseService;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository, CourseService courseService) {
		this.studentRepository = studentRepository;
		this.courseService = courseService;
	}

	@Override
	public Student save(Student student) {
		student.setId(0);
		int courseId = student.fetchCourseId();
		
		if(courseId!=0)
		{
			Course c = courseService.findById(courseId);
			c.addStudent(student);
	
		}
		return studentRepository.save(student);
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	public Student findById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent())			
			return s.get();
		else
			throw new RuntimeException("Student not found with id "+id);
	}

	@Override
	public Student update(Student student) {
		
		Student s = findById(student.getId());
		
		s.setFirstName(student.getFirstName()); 
		s.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		
		int courseId = student.fetchCourseId();
		Course c = new Course();
		if(courseId!=0)
		{
			c = courseService.findById(courseId);
			c.addStudent(s);
			//courseService.save(c);
		}

		return studentRepository.save(s);
	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);

	}

}
