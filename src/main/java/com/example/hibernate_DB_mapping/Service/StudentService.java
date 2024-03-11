package com.example.hibernate_DB_mapping.Service;

import java.util.List;

import com.example.hibernate_DB_mapping.Entity.Student;

public interface StudentService {
	
	Student save(Student student);
	
	List<Student> findAll();

	Student update(Student student);
	
	void delete(int id);

}
