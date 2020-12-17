package com.microservices.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.microservices.exception.ResourceNotFoundException;
import com.microservices.model.Price;
import com.microservices.model.Product;
import com.microservices.model.Review;
import com.microservices.model.Stock;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/microservices")
public class MyController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("review/{id}")
	public Review[] getReviews(@PathVariable long id) throws ResourceNotFoundException {
		try {
			return restTemplate.getForObject("http://localhost:9020/api/v1/review/" + id, Review[].class);

		}

		catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Id not found");
		}

	}

	@PostMapping("/review")
	public ResponseEntity<?> createReview(@RequestBody Review review, UriComponentsBuilder uriComponentsBuilder,
			HttpServletRequest request) {

		Review review1 = restTemplate.postForObject("http://localhost:9020/api/v1/review", review, Review.class);

		UriComponents uriComponents = uriComponentsBuilder.path(request.getRequestURI() + "/{id}")
				.buildAndExpand(review1.getProductId());
		return ResponseEntity.created(uriComponents.toUri()).body(review1);
	}

	@DeleteMapping("/review/{id}")
	public Map<String, Boolean> deleteReview(@PathVariable long id) throws ResourceNotFoundException {

		Map<String, Boolean> responseMap = new HashMap();
		try {
			Review review1 = restTemplate.getForObject("http://localhost:9020/api/v1/review/getProduct/" + id,
					Review.class);
		}

		catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Review not found");
		}

		restTemplate.delete("http://localhost:9020/api/v1/review/" + id);

		responseMap.put("deleted", Boolean.TRUE);
		return responseMap;

	}

	@PutMapping("/{id}")
	public void UpdateStock(@PathVariable("id") Integer id, @Valid @RequestBody Review review) {
		restTemplate.put("http://localhost:9020/api/v1/review/" + id, review);

	}

	@GetMapping("/stock/{id}")
	public Stock getStock(@PathVariable long id) {

		return restTemplate.getForObject("http://localhost:9090/api/stock/" + id, Stock.class);

	}

	@PostMapping("/stock")
	public Stock PostStock(@RequestBody Stock stock) {

		return restTemplate.postForObject("http://localhost:9090/api/stock/", stock, Stock.class);

	}

	@DeleteMapping("/stock/{id}")
	public void Delete(@PathVariable long id) {

		restTemplate.delete("http://localhost:9090/api/stock/" + id);

	}

	// Get all stocks
	@GetMapping("/stock/")
	public Stock[] getAllStocks() {

		return restTemplate.getForObject("http://localhost:9090/api/stock/", Stock[].class);

	}

	// Get stock by product ID
	@GetMapping("/stock/productId/{id}")
	public Stock getStockByProductId(@PathVariable long id) {

		return restTemplate.getForObject("http://localhost:9090/api/stock/productId/" + id, Stock.class);

	}

	// Update
	@PutMapping("/stock/{id}")
	public ResponseEntity<@Valid Stock> UpdateStock(@PathVariable("id") Integer id, @Valid @RequestBody Stock stock) {
		restTemplate.put("http://localhost:9090/api/stock/" + id, stock);

		return ResponseEntity.ok(stock);

	}

	@GetMapping("/price")
	public Price[] getPrices() {
		return restTemplate.getForObject("http://localhost:9010/api/v1/price", Price[].class);
	}

	@GetMapping("/price/{id}")
	public Price getPriceById(@PathVariable long id) throws ResourceNotFoundException {
		try {
			return restTemplate.getForObject("http://localhost:9010/api/v1/price/" + id, Price.class);
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Id not found");
		}
	}

	@PostMapping("/price")
	public ResponseEntity<?> createPrice(@RequestBody Price price, UriComponentsBuilder uriComponentsBuilder,
			HttpServletRequest request) {
		Price price1 = restTemplate.postForObject("http://localhost:9010/api/v1/price", price, Price.class);
		UriComponents uriComponents = uriComponentsBuilder.path(request.getRequestURI() + "/{id}")
				.buildAndExpand(price1.getProductId());
		return ResponseEntity.created(uriComponents.toUri()).body(price1);
	}

	@DeleteMapping("/price/{id}")
	public Map<String, Boolean> deletePrice(@PathVariable long id) throws ResourceNotFoundException {
		Map<String, Boolean> responseMap = new HashMap();
		try {
			Price price1 = restTemplate.getForObject("http://localhost:9010/api/v1/price/" + id, Price.class);
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Price not found");
		}
		restTemplate.delete("http://localhost:9010/api/v1/price/" + id);
		responseMap.put("deleted", Boolean.TRUE);
		return responseMap;
	}

	@PutMapping("/price/{id}")
	public ResponseEntity<@Valid Price> UpdatePrice(@PathVariable("id") Long id, @Valid @RequestBody Price price) {
		restTemplate.put("http://localhost:9010/api/v1/price/" + id, price);
		return ResponseEntity.ok(price);
	}

	@GetMapping("/product")
	public Product[] getProducts() throws ResourceNotFoundException {
		try {
			return restTemplate.getForObject("http://localhost:9011/api/v1/product/", Product[].class);
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Id not found");
		}

	}

	@GetMapping("/product/category/{category}")
	public Product[] getProductsByCategory(@PathVariable String category) throws ResourceNotFoundException {
		try {
			return restTemplate.getForObject("http://localhost:9011/api/v1/product/category/" + category,
					Product[].class);
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Id not found");
		}

	}

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable long id) throws ResourceNotFoundException {
		try {
			return restTemplate.getForObject("http://localhost:9011/api/v1/product/" + id, Product.class);
		} catch (HttpClientErrorException e) {
			throw new ResourceNotFoundException("Id not found");
		}

	}

	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
			return restTemplate.postForObject("http://localhost:9011/api/v1/product/",product, Product.class);
	}

	// @PostMapping("/product")
	// public Product PostProduct(@RequestBody Product product) {
	//
	// return restTemplate.postForObject("http://localhost:9010/api/product/" ,
	// product, Product.class);
	//
	// }
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable long id) {
		restTemplate.delete("http://localhost:9011/api/v1/product/" + id);
	}

}
