package com.example.hibernate_DB_mapping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate_DB_mapping.Entity.Instructor;
import com.example.hibernate_DB_mapping.Repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	
	private InstructorRepository instructorRepository;
	
	@Autowired
	public InstructorServiceImpl(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}


	public Instructor save(Instructor ins)
	{	
		ins.setId(0);
		ins.getInstructorDetail().setId(0);
		return instructorRepository.save(ins);
		
	}


	@Override
	public List<Instructor> findAll() {
		
		List<Instructor> list = instructorRepository.findAll();
		//System.out.println("Print line" + list);
		return list;
	}


	@Override
	public Instructor findById(int id) {
		Optional<Instructor> ins = instructorRepository.findById(id);
		
		if(ins.isPresent())
			return ins.get();
		else
			throw new RuntimeException("Instructor Not found with id "+id);
		
		
	}


	@Override
	public void delete(int id) {
		Instructor tenpInstructor = findById(id);
		System.out.println(tenpInstructor);
		instructorRepository.delete(tenpInstructor);
		
	}


	@Override
	public Instructor update(Instructor ins) {
		Instructor tenpInstructor = findById(ins.getId());	
		
		if(tenpInstructor== null)
			throw new RuntimeException("Instructor Not found!! ");
		
		 return instructorRepository.save(ins);
	}

}
