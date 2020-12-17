package com.tcs.stock.controller;

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

import com.tcs.stock.exception.ResourceNotFoundException;
import com.tcs.stock.model.Stock;
import com.tcs.stock.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
	@Autowired
	StockService stockService;
	
	//Get all stocks
	@GetMapping
	public List<Stock> getStocks() {
		return stockService.getStocks().get();
	}
	
	//Get stock by  stock ID
	@GetMapping("/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable("id") int stockId) throws ResourceNotFoundException {
		Stock stock = stockService.getStockById(stockId).orElseThrow(()-> new ResourceNotFoundException("Stock not found"));
		
		return ResponseEntity.ok().body(stock);
	}
	
	//Get stock by product ID
		@GetMapping("/productId/{id}")
		public ResponseEntity<Stock> getStockByProductId(@PathVariable("id") int productId) throws ResourceNotFoundException {
			Stock stock = stockService.getStockByProductId(productId).orElseThrow(()-> new ResourceNotFoundException("Stock not found for this product ID"));
			
			return ResponseEntity.ok().body(stock);
		}
	
	//Create new stock
	@PostMapping
	public ResponseEntity<?> createStock(@RequestBody Stock stock,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request) {
	
		Stock stock2 = stockService.createStock(stock);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(stock2.getStockId());
		
		
	  return 	 ResponseEntity.created(uriComponents.toUri()).body(stock2);
	}
	
	
	//Delete Stock by ID
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteStockById(@PathVariable int id) throws ResourceNotFoundException { 
		Stock stock = stockService.getStockById(id).orElseThrow(()-> new ResourceNotFoundException("Stock not found"));
		
		stockService.deleteStock(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		
		return hashMap;
	}
	
	//Update Stock by ID
	@PutMapping("/{id}")
	
	public ResponseEntity<Stock> updateStock(@PathVariable("id") Integer id,
			@Valid @RequestBody Stock stock ) throws ResourceNotFoundException {
		Stock stock2 = stockService.getStockById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Stock not found"));
		stock.setStockId(id);
		Stock stock3 =stockService.createStock(stock);
		
		return ResponseEntity.ok(stock3);
	}
	
	
}
