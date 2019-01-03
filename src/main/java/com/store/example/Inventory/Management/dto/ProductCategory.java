
package com.store.example.Inventory.Management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
"categoryName",
"isDiscounted",
"discountRate"
})

public class ProductCategory {

	@JsonProperty("categoryName")
	private String categoryName;
	
	@JsonProperty("isDiscounted")
	private boolean isDiscounted;
	
	@JsonProperty("discountRate")
	private int discountRate;
}
