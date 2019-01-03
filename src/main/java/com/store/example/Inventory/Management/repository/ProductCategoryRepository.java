package com.store.example.Inventory.Management.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.example.Inventory.Management.model.ProductCategory;

public interface ProductCategoryRepository  extends CrudRepository<ProductCategory, Integer>{

}
