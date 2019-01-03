package com.store.example.Inventory.Management.service;

import java.util.List;

import com.store.example.Inventory.Management.dto.CustomerEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;
import com.store.example.Inventory.Management.model.Customer;
import com.store.example.Inventory.Management.model.Invoice;

public interface CustomerService {
	 List<Customer> listAll();
	 StatusResponse addCustomer(CustomerEntry customerEntry);
	 Customer getCustomerDetails(int customerId);

}
