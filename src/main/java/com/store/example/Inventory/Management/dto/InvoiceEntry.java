package com.store.example.Inventory.Management.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
"invoiceId",
"customerId",
"lineItems",
"register"
})


@Getter
@Setter
public class InvoiceEntry {

	@JsonProperty("invoiceId")
	private int invoiceId;
	
	@JsonProperty("customerId")
	private int customerId;
	
	@JsonProperty("register")
	private int register;

	@JsonProperty("lineItems")
	private Set<InvoiceItem> lineItems;
	
	
	
}
