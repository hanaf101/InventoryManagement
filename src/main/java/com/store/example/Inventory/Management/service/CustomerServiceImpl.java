package com.store.example.Inventory.Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.example.Inventory.Management.dto.CustomerEntry;
import com.store.example.Inventory.Management.dto.StatusResponse;
import com.store.example.Inventory.Management.model.Customer;
import com.store.example.Inventory.Management.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> listAll() {

		List<Customer> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add); 
		return customers;
	}


	@Override
	public Customer getCustomerDetails(int customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}


	@Override
	public StatusResponse addCustomer(CustomerEntry customerEntry) {
		StatusResponse statusResponse = new StatusResponse();
		statusResponse.setStatus("SUCCESS");
		Customer customer = new Customer();
		customer.setCustomerId(customerEntry.getCustomerId());
		customer.setCustomerName(customerEntry.getCustomerName());
		customer.setDateOfBirth(customerEntry.getDateOfBirth());
		customer.setEmployee(customerEntry.isEmployee());
		customerRepository.save(customer);
		return statusResponse;
	}

}
