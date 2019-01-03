package com.store.example.Inventory.Management.service;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.example.Inventory.Management.dto.DailySummary;
import com.store.example.Inventory.Management.dto.InvoiceEntry;
import com.store.example.Inventory.Management.dto.InvoiceItem;
import com.store.example.Inventory.Management.dto.StatusResponse;
import com.store.example.Inventory.Management.model.Invoice;
import com.store.example.Inventory.Management.model.InvoiceLineItem;
import com.store.example.Inventory.Management.model.Product;
import com.store.example.Inventory.Management.repository.InvoiceLineItemRepository;
import com.store.example.Inventory.Management.repository.InvoiceRepository;
import com.store.example.Inventory.Management.repository.ProductRepository;
import com.store.example.Inventory.Management.utils.ServiceUtils;

public class InvoiceServiceImpl  implements InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	InvoiceLineItemRepository invoiceLineItemRepository;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;
	
	


	@Override
	public StatusResponse getSummary(Date date) {
		
		StatusResponse statusResponse = new StatusResponse();
		int totalSale = invoiceRepository.getSummary(date);
		DailySummary dailySummary = new DailySummary();
		dailySummary.setDate(date);
		dailySummary.setTotalSale(totalSale);
		String summary = ServiceUtils.getStringfromObject(dailySummary);
		statusResponse.setStatus("SUCCESS");
		statusResponse.setDescription(summary);
		return statusResponse;
	}



	@Override
	public StatusResponse addInvoice(InvoiceEntry invoiceEntry) {
		
		StatusResponse statusResponse = new StatusResponse();
		
		Invoice invoice =  new Invoice();
		invoice.setCustomerId(invoiceEntry.getCustomerId());
		invoice.setOrderDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
		invoice.setRegister(invoiceEntry.getRegister());
		Invoice savedInvoice = invoiceRepository.save(invoice);
		for(InvoiceItem invoiceItem : invoiceEntry.getLineItems()) {
			InvoiceLineItem lineItem = new InvoiceLineItem();
			lineItem.setInvoiceNumber(savedInvoice.getInvoiceId());
			lineItem.setProductId(invoiceItem.getProductId());
			
			Product product = productService.getProduct(invoiceItem.getProductId());
			if(product.getStock() - lineItem.getQuantity() > 0) {
				lineItem.setQuantity(invoiceItem.getQuantity());
			    product.setStock(product.getStock() - invoiceItem.getQuantity());
			    productRepository.save(product);
			    invoiceLineItemRepository.save(lineItem);
			} else {
				statusResponse.setStatus("FAILED");
				statusResponse.setDescription("No Sufficient Stocks");
				invoiceRepository.delete(savedInvoice);
				return statusResponse;
			}
		}
		
		statusResponse.setStatus("SUCCESS");
		statusResponse.setDescription("Invoice Added Successfully");
		return statusResponse;
	}

}
