package com.example.hibernate_DB_mapping.Service;

import java.util.List;

import com.example.hibernate_DB_mapping.Entity.Instructor;

public interface InstructorService {
	
	Instructor save(Instructor ins);
	
	List<Instructor> findAll();
	
	Instructor findById(int id);
	
	void delete(int id);
	
	Instructor update (Instructor ins);
	

}
