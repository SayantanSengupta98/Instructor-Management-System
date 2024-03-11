package com.example.hibernate_DB_mapping.Service;

import java.util.List;

import com.example.hibernate_DB_mapping.Entity.InstructorDetail;

public interface InstructorDetailService {
	
	InstructorDetail save(InstructorDetail instructorDetail);
	
	List<InstructorDetail> findAll();
	
	InstructorDetail findById(int id);
	
	void delete(int id);
	
	InstructorDetail update (InstructorDetail ins);
	

}
