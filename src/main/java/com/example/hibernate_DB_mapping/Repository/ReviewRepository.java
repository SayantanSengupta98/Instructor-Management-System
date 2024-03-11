package com.example.hibernate_DB_mapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hibernate_DB_mapping.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
