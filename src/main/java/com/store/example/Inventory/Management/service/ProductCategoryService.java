package com.store.example.Inventory.Management.service;

import com.store.example.Inventory.Management.dto.DiscountRequest;
import com.store.example.Inventory.Management.dto.StatusResponse;

public interface ProductCategoryService {

	StatusResponse addDiscount(DiscountRequest discountRequest);
	
	int getDiscountRate(int ProductCategoryId);
	
}
