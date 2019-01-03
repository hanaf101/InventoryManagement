package com.store.example.Inventory.Management.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
"customerId",
"DOB",
"customerName",
"isEmployee"
})
public class CustomerEntry {
	
	@JsonProperty("customerId")
    int customerId;

	
    @JsonProperty("DOB")
    Date dateOfBirth;
	
    @JsonProperty("customerName")
	private String customerName;
	
    @JsonProperty("isEmployee")
	private boolean isEmployee;
	
}
