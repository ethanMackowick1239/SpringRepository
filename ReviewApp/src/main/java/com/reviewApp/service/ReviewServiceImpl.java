package com.reviewApp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewApp.model.Review;
import com.reviewApp.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        Review review1 = null;
        try {
            review1 = reviewRepository.save(review);
            return review1;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Review updateReview(Review review) {
        Review review2 = null;
        try {
            review2 = reviewRepository.save(review);
            return review2;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String deleteReview(long id) {
        reviewRepository.deleteById(id);
        return ("deleted");
    }

    @Override
    public Optional<Review> getProductById(long productId) {
        Optional<Review> byId = reviewRepository.findById(productId); // provide the product based on id from database
        Review review = byId.orElse(null); // if the product is available then it will save product info on product
        return Optional.ofNullable(review);
    }

	@Override
	public Optional<List<Review>> getReviews(long productId) {
		Optional<List<Review>> reviews = reviewRepository.findByProductId(productId);
		List<Review> reviewList = reviews.orElse(null);
        return Optional.ofNullable(reviewList);
		
	}
	@Override
	public Optional<List<Review>> getAllReviews() {
		Optional<List<Review>> reviews = Optional.ofNullable(reviewRepository.findAll());
		List<Review> reviewList = reviews.orElse(null);
		return Optional.of(reviewList);
		
	}
	



}
