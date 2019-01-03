package com.store.example.Inventory.Management.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.store.example.Inventory.Management.model.ProductCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
"unitePrice",
"stock",
"lastStockOn",
"ProductCategory"
})

public class ProductEntry {
	
	@JsonProperty("unitePrice")
	private int unitePrice;
	
	@JsonProperty("stock")
	private int stock;

	@JsonProperty("lastStockOn")
	private Timestamp lastStockOn;
	
	@JsonProperty("ProductCategory")
    private ProductCategory ProductCategory;


}
