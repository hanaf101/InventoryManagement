package com.store.example.Inventory.Management.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hanaf
 * Invoice number is auto generated
 * An invoice can have multiple line items, As each item is 
 * added logic is written to decrement from the stocks in product table
 * Register info is also captured
 *
 */

@Getter
@Setter
@Entity
@IdClass(InvoicePK.class)
public class Invoice {

	@Id
	@Column(name = "invoice_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private int invoiceId;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    
	@Column(name = "order_date")
	private Date orderDate;

	@Column(name = "total")
	private int total;
	
	@Column(name = "register")
	private int register;

	@OneToMany(mappedBy = "invoice_id", cascade = CascadeType.ALL)
	private Set<InvoiceLineItem> invoiceLineItems;
	
	

}
