package com.tcs.priceservice.service;

import java.util.Optional;
import com.tcs.priceservice.model.Price;

public interface PriceService {
	public Price createPrice(Price price);
	public Optional<Price> getPriceById(long id);
	public Optional<Price> getPriceByProductId(long id);
	public void deletePrice(long id);
	public Optional<java.util.List<Price>>getPrices();
	
	
	
}
