package com.tcs.stock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.stock.model.Stock;
import com.tcs.stock.repository.StockRepository;

@Service
public class StockService {
// applying singleton 
	// task for u
	
	
	@Autowired
	StockRepository stockRepository;
	
	public Stock createStock(Stock stock) {
		// TODO Auto-generated method stub
		Stock stock2 = null;
		try {
			stock2 = stockRepository.save(stock);
			return stock2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Optional<Stock> getStockById(long id) {
		// TODO Auto-generated method stub
		
		
		return stockRepository.findById(id);
	}
	
	public Optional<Stock> getStockByProductId(long id) {
		// TODO Auto-generated method stub
		
		
		return stockRepository.findByProductId(id);
	}

	public void deleteStock(long id) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(id);
	}

	public Optional<List<Stock>> getStocks() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(stockRepository.findAll());
	}


}
