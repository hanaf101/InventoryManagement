package com.store.example.Inventory.Management.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hanaf
 * 
 * Each Product is associated with a product category. It is associated with Product Category in ManyToOne relation.
 *
 */

@Getter
@Setter
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String categoryName;
	

	@Column(name="unit_price")
	private int unitePrice;
	

	@Column(name="stock")
	private int stock;

	@Column(name="last_stock_on")
	private Timestamp lastStockOn;
	

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "product_category")
    private List<Product> Products;


}
