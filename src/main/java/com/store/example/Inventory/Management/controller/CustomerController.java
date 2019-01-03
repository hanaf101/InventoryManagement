package com.store.example.Inventory.Management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.example.Inventory.Management.dto.CustomerEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;


public class CustomerController {
	
	@GetMapping(value = "/customers")
	public ResponseEntity<StatusResponse> queryjob() {
		StatusResponse statusResponse = new StatusResponse();
		
	
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/customers", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<StatusResponse> addNewEvent(@RequestBody CustomerEntry customerEntry) throws Exception {
		StatusResponse statusResponse = new StatusResponse();
		
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}

}
