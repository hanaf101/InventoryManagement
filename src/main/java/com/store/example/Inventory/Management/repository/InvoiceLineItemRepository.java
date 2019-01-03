package com.store.example.Inventory.Management.repository;

import org.springframework.data.repository.CrudRepository;

import com.store.example.Inventory.Management.model.InvoiceLineItem;

public interface InvoiceLineItemRepository  extends CrudRepository<InvoiceLineItem, Integer>{

}
