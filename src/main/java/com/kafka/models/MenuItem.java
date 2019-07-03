package com.kafka.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;
import lombok.Getter;

@Data
public class MenuItem {
	
	@Getter private String itemName;
	@Getter private String itemDescription;
	@Getter private String itemPrice;
	@Getter private String itemQuantity;
	@Getter private String itemCategory;
	@Getter private String eventTimestamp;	
	
	@JsonCreator
	public MenuItem(String itemName, String itemDescription, String itemPrice, String itemQuantity, String itemCategory, String eventTimestamp) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemCategory = itemCategory;
		this.itemQuantity = itemQuantity;
		this.eventTimestamp = eventTimestamp;
	}
}
