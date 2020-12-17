package com.reviewApp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reviewApp.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	Optional<List<Review>> findByProductId(long id);
}
