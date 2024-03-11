package com.example.hibernate_DB_mapping.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernate_DB_mapping.Entity.Review;
import com.example.hibernate_DB_mapping.Service.ReviewService;

@RestController
@RequestMapping("/one2manyuni")
public class ReviewController {
	 
	ReviewService revService;

	public ReviewController(ReviewService revService) {
		super();
		this.revService = revService;
	}
	
	@PostMapping("/review")
	public Review saveReview(@RequestBody Review rev)
	{
		return revService.save(rev);
	}
	
	@PutMapping("/review")
	public Review updateReview(@RequestBody Review rev)
	{
		return revService.update(rev);
	}
	
	@GetMapping("/review")
	public List<Review> getReview()
	{
		return revService.findAll();
	}
	
	@DeleteMapping("/review/{id}")
	public String deleteReview(@PathVariable int id)
	{
		revService.delete(id);
		return ("Review deleted  with id "+id); 
	}
}
