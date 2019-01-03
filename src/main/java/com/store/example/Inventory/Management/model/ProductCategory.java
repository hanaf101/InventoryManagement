package com.store.example.Inventory.Management.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hanaf
 *
 *Discount for each product category can be defined here. 
 */
@Getter
@Setter
@Entity
public class ProductCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "is_Discounted")
	private boolean isDiscounted;
	
	@Column(name="discount_rate")
	private int discountRate;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category", referencedColumnName = "id",  nullable = false)
	private ProductCategory ProductCategory;

}
