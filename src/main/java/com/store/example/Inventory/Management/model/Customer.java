package com.store.example.Inventory.Management.model;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author hanaf
 * Customer is identified whether senior citizen or not based on DOB
 * A customer can have many invoices ( one to many relation)
 *
 */

@Entity
@Getter
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "customer_id")
	private int customerId;
	
	
	@Basic
	@Column(name = "customerName")
	private String customerName;
	
	@Basic
	@Column(name = "date_of_birth")
	private java.sql.Date dateOfBirth;
	

	@Column(name = "is_employee")
	private boolean isEmployee;
	
	@OneToMany(mappedBy = "customer_id", cascade = CascadeType.ALL)
	private Set<Invoice> invoices;
	
}
