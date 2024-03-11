package com.example.hibernate_DB_mapping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hibernate_DB_mapping.Entity.InstructorDetail;
import com.example.hibernate_DB_mapping.Repository.InstructorDetailRepository;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {
	
	InstructorDetailRepository detailRepo;
	
	public InstructorDetailServiceImpl(InstructorDetailRepository detailRepo) {
		this.detailRepo = detailRepo;
	}

	@Override
	public InstructorDetail save(InstructorDetail instructorDetail) {
		instructorDetail.setId(0);
		instructorDetail.getInstructor().setId(0);
		instructorDetail.getInstructor().setInstructorDetail(instructorDetail);
		return detailRepo.save(instructorDetail);
	}

	@Override
	public List<InstructorDetail> findAll() {
		return detailRepo.findAll();
	}

	@Override
	public InstructorDetail findById(int id) {
		Optional<InstructorDetail> insDetail = detailRepo.findById(id);
		
		if(insDetail.isPresent())
			return insDetail.get();
		else
			throw new RuntimeException("Instructor detail Not found with id "+id);
	}

	@Override
	public void delete(int id) {
		InstructorDetail insDetail = findById(id);
		detailRepo.delete(insDetail);
	}

	@Override
	public InstructorDetail update(InstructorDetail ins) {
		InstructorDetail tenpInstructor = findById(ins.getId());	
		ins.getInstructor().setInstructorDetail(ins);
		if(tenpInstructor== null)
			throw new RuntimeException("Instructor Not found!! ");
		
		 return detailRepo.save(ins);
	}

}
