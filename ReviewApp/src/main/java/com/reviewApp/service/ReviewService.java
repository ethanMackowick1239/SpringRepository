package com.reviewApp.service;

import java.util.List;
import java.util.Optional;

import com.reviewApp.model.Review;

public interface ReviewService {
    public Review createReview(Review review);
    public Review updateReview(Review review);
    public String deleteReview(long id);
    public Optional<Review> getProductById(long id);
	public Optional<List<Review>> getReviews(long productId);
	public Optional<List<Review>> getAllReviews();
}
