package com.store.example.Inventory.Management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	@Column(name = "invoice_id")
	private int invoiceId;
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
	
    @ManyToMany
    @JoinColumn(name = "product_id")
    private Product product;
	
	@Column(name = "unit_price")
	private int unitPrice;
	
	@Column(name = "quantity")
	private int quantity;

}

