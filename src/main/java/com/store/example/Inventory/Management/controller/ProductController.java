package com.store.example.Inventory.Management.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.example.Inventory.Management.dto.DiscountRequest;
import com.store.example.Inventory.Management.dto.ProductEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;
import com.store.example.Inventory.Management.model.ProductCategory;
import com.store.example.Inventory.Management.service.ProductService;
import com.store.example.Inventory.Management.utils.ServiceUtils;

public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * Add a new discount entry for a particular category. Set isDiscounted flag as false if discount is to be discontinued
	 * @param discountRequest
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/discount", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<StatusResponse> updateDiscount(@RequestBody DiscountRequest discountRequest) throws Exception {
		StatusResponse statusResponse;

		statusResponse = productService.updateDiscount(discountRequest);
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}
	
	/**
	 * Add a new product category.
	 * @param ProductCategory
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/productCategory", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<StatusResponse> addProductCategory(@RequestBody ProductCategory productCategory) throws Exception {
		StatusResponse statusResponse;

		statusResponse = productService.addProductCategory(productCategory);
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}

	/**
	 * Add a new product along with stocks details.
	 * @param ProductEntry
	  * @return StatusResponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/product", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<StatusResponse> addProduct(@RequestBody ProductEntry productRequest) throws Exception {
		StatusResponse statusResponse;

		statusResponse = productService.addProduct(productRequest);
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}
	
	@GetMapping(value = "/products")
	public ResponseEntity<StatusResponse> getProducts(@RequestParam(value = "date") Date date) {
		StatusResponse statusResponse = new StatusResponse();
		statusResponse.setStatus("SUCCESS");
		statusResponse.setDescription(ServiceUtils.getStringfromObject(productService.getAllProducts()));
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}
	
	
	/**
	 * To get summary of sales for a paticular date
	 * @param date
	 * @return StatusResponse
	 */

	@GetMapping(value = "/getSummary")
	public ResponseEntity<StatusResponse> getSummary(@RequestParam(value = "date") Date date) {
		StatusResponse statusResponse;
		statusResponse = productService.getSummary(date);
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}
	
	
}
