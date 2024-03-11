package com.example.hibernate_DB_mapping.Service;

import java.util.List;

import com.example.hibernate_DB_mapping.Entity.Review;

public interface ReviewService {
	
	Review save(Review rev);
	
	List<Review> findAll();

	Review update(Review rev);
	void delete(int id);
	
	
}
