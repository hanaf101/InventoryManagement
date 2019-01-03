package com.store.example.Inventory.Management.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
"productId",
"unitPrice",
"quantity"
})

@Getter
@Setter
public class InvoiceItem {

    @JsonProperty("productId")
	private int productId;
    
    @JsonProperty("unitPrice")
	private int unitPrice;
	
    @JsonProperty("quantity")
	private int quantity;

}
