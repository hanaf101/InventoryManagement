package com.store.example.Inventory.Management.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.example.Inventory.Management.model.Product;

public interface ProductRepository  extends CrudRepository<Product, Integer>{

}
