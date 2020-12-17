package com.tcs.priceservice.controller;

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

import com.tcs.priceservice.model.Price;
import com.tcs.priceservice.service.PriceService;
import com.tcs.priceservice.exception.ResourceNotFoundException;


@RestController
@RequestMapping("/api/v1/price")
public class PriceController {

	@Autowired
	PriceService priceService;
	
	@GetMapping
	public List<Price> getPrices(){
		return priceService.getPrices().get();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Price> getPriceById(@PathVariable("id") long priceId) throws ResourceNotFoundException{
		Price price = priceService.getPriceById(priceId).orElseThrow(()-> new ResourceNotFoundException("Price not found"));
		
		return ResponseEntity.ok().body(price);
	}
	
	@GetMapping("/productId/{id}")
	public ResponseEntity<Price> getPriceByProductId(@PathVariable("id") long productId) throws ResourceNotFoundException{
		Price price = priceService.getPriceByProductId(productId).orElseThrow(()-> new ResourceNotFoundException("Price not found"));
	
		return ResponseEntity.ok().body(price);
	}
	
	@PostMapping
	public ResponseEntity<?> createPrice(@RequestBody Price price,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Price price2 = priceService.createPrice(price);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(price2.getPriceId());
		
		
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(price2);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteProductById(@PathVariable long id) throws ResourceNotFoundException { 
		Price price = priceService.getPriceById(id).orElseThrow(()-> new ResourceNotFoundException("Price not found"));
		
		priceService.deletePrice(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
	
	
	@PutMapping("/{id}")
	
	public ResponseEntity<Price> updateProduct(@PathVariable("id") Long id,
			@Valid @RequestBody Price price ) throws ResourceNotFoundException {
		Price price2 = priceService.getPriceById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Price not found"));
		price.setPriceId(id);
		Price price3 =priceService.createPrice(price);
		
		return ResponseEntity.ok(price3);
	}
	
}
