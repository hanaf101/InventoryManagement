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

import com.store.example.Inventory.Management.dto.InvoiceEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;
import com.store.example.Inventory.Management.service.InvoiceService;

public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	
	/**
	 * Lists down all invoice in a given date, TBD
	 * @param date
	 * @return
	 */
	@GetMapping(value = "/invoices")
	public ResponseEntity<StatusResponse> queryjob(@RequestParam(value = "jobId") Date date) {
		StatusResponse statusResponse = new StatusResponse();
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}
	
	/**
	 * Add an invoice along with line items. Price according to discounts  and update stock details. 
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "/invoice", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<StatusResponse> addnewInvoice(@RequestBody InvoiceEntry invoiceEntry) throws Exception {
		StatusResponse statusResponse;
		
		statusResponse  = invoiceService.addInvoice(invoiceEntry);
		return new ResponseEntity<>(statusResponse, HttpStatus.OK);
	}

}
