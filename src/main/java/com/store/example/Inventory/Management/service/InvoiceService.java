package com.store.example.Inventory.Management.service;

import java.sql.Date;

import com.store.example.Inventory.Management.dto.InvoiceEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;



public interface InvoiceService {

	   StatusResponse addInvoice(InvoiceEntry invoiceEntry);
	   StatusResponse getSummary(Date date);
}
