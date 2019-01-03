package com.store.example.Inventory.Management.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
"date",
"totalSale"
})
public class DailySummary {

	@JsonProperty("date")
    Date date;

    @JsonProperty("totalSale")
    int totalSale;

}
