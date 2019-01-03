package com.store.example.Inventory.Management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@JsonPropertyOrder({
"categoryId",
"discountRate"
})
public class DiscountRequest {
	
	@JsonProperty("categoryId")
    String categoryId;

    @JsonProperty("discountRate")
    int discountRate;
	

}
