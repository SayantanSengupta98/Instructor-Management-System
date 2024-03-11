package com.example.hibernate_DB_mapping.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.hibernate_DB_mapping.Entity.Course;
import com.example.hibernate_DB_mapping.Entity.Review;
import com.example.hibernate_DB_mapping.Repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	ReviewRepository reviewRepo;
	CourseService courseservice;
	
	
	public ReviewServiceImpl(ReviewRepository reviewRepo, CourseService courseservice) {
		this.reviewRepo = reviewRepo;
		this.courseservice = courseservice;
	}

	@Override
	public Review save(Review rev) {
		System.out.println(rev);
		rev.setId(0);
		int courseId = rev.fetchCourseId();
		Course c = courseservice.findById(courseId);
		c.addReviews(rev);
		reviewRepo.save(rev);		
		return rev;
	}

	@Override
	public List<Review> findAll() {
		return reviewRepo.findAll();
	}



	@Override
	public void delete(int id) {
		reviewRepo.deleteById(id);

	}

	@Override
	public Review update(Review rev) {
		Optional<Review> review = reviewRepo.findById(rev.getId());
		if(review.isPresent())
			return reviewRepo.save(rev);	
		else
			throw new RuntimeException("Provided review does not exist");
		
	}

}
