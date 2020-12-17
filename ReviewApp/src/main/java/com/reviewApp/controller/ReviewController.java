package com.reviewApp.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.reviewApp.model.Product;
//import com.reviewApp.model.Review;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@Controller
//@RequestMapping("/api/v1/review")
//public class ReviewController {
//	
//	@Autowired
//	RestTemplate restTemplate;
//	
//    @PostMapping
//    public ResponseEntity<?> createReview(@RequestBody Review review, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest request){
//
//        Product product1 = restTemplate.postForObject("http://localhost:9010/api/v1/product/", request, Product.class);
//        UriComponents uriComponents = uriComponentsBuilder
//                .path(request.getRequestURI() + "/{id}").buildAndExpand(product1.getProductId());
//        return ResponseEntity.created(uriComponents.toUri()).body(product1);
//
//    }
//
//}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.reviewApp.exception.ResourceNotFoundException;
import com.reviewApp.model.Review;
import com.reviewApp.service.ReviewService;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
	
    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody Review review, UriComponentsBuilder uriComponentsBuilder, HttpServletRequest request){

        Review review1 = reviewService.createReview(review);
        UriComponents uriComponents = uriComponentsBuilder
                .path(request.getRequestURI() + "/{id}").buildAndExpand(review1.getProductId());
        return ResponseEntity.created(uriComponents.toUri()).body(review1);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") Long id,
                                                 @Valid @RequestBody Review review) throws ResourceNotFoundException {
        reviewService.getProductById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Review not found"));
        review.setId(id);
        Review review2 = reviewService.createReview(review);
        return ResponseEntity.ok(review2);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteReview(@PathVariable long id) throws ResourceNotFoundException {
        Review review = reviewService.getProductById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        reviewService.deleteReview(id);
        HashMap<String, Boolean> hashMap = new HashMap<>();
        hashMap.put("deleted", Boolean.TRUE);
        return hashMap;
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Review> getReviewbyId(@PathVariable("id") long productId) throws ResourceNotFoundException {

        Review review = reviewService.getProductById(productId).orElseThrow(()-> new ResourceNotFoundException("Review not found"));
        return ResponseEntity.ok().body(review);
    }
    
	@GetMapping("/{id}")
	public ResponseEntity<List<Review>> getProductById(@PathVariable("id") int productId) throws ResourceNotFoundException {
		List<Review >reviews =  reviewService.getReviews(productId).orElseThrow(()-> new ResourceNotFoundException("Review not found"));
		
		return ResponseEntity.ok().body(reviews);
	}
	
	@GetMapping
	public ResponseEntity<List<Review>> getProducts() {
		
		List<Review> reviews = reviewService.getAllReviews().get();
		return ResponseEntity.ok().body(reviews);
	}



}
