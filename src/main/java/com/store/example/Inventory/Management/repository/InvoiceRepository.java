package com.store.example.Inventory.Management.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.store.example.Inventory.Management.model.Invoice;


public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {
	

	@Query("select SUM(total) from Invoice invoice where invoice.date = :date")
	public int getSummary(@Param("date") Date date);

}
