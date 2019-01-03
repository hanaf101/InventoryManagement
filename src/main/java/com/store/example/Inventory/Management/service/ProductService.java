package com.store.example.Inventory.Management.service;

import java.sql.Date;
import java.util.List;

import com.store.example.Inventory.Management.dto.DiscountRequest;
import com.store.example.Inventory.Management.dto.ProductEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;
import com.store.example.Inventory.Management.model.Product;
import com.store.example.Inventory.Management.model.ProductCategory;

public interface ProductService {

	List<Product> getAllProducts();
	
	Product getProduct(int productId);
	
	StatusResponse updateDiscount(DiscountRequest discountRequest);

	StatusResponse addProductCategory(ProductCategory productCategory);

	StatusResponse addProduct(ProductEntry productRequest);
	
	StatusResponse getSummary(Date date);
}
