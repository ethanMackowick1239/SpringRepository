package com.tcs.priceservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.priceservice.model.Price;
@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	List<Price> findByPriceId(long id);
	List<Price> findByProductId(long id);
	List<Price> findByPriceValue(float priceValue);
	
}
