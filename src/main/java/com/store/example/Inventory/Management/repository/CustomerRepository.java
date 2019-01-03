package com.store.example.Inventory.Management.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.example.Inventory.Management.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
