package com.store.example.Inventory.Management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hanaf
 * 
 * Line Items for each invoice 
 *
 */
@Getter
@Setter
@Entity
@IdClass(InvoiceLineItemPK.class)
public class InvoiceLineItem {
	
	@Id
	@Column(name="invoice_id")
	private int InvoiceNumber;
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "unit_price")
	private int unitPrice;
	
	@Column(name = "quantity")
	private int quantity;

}

