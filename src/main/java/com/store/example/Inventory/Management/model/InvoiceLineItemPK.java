package com.store.example.Inventory.Management.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class InvoiceLineItemPK {
	

	private int invoiceId;
	
	private int productId;
	

}
