package com.tcs.stock.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	Optional<Stock> findById(Long Id);
	Optional<Stock> findByProductId(Long Id);
	
}
