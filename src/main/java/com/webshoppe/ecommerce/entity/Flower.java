package com.webshoppe.ecommerce.entity;

import java.math.BigDecimal;

public class Flower {

	private String flowerID;
	private String flowerName;
	private String flowerDescription;
	private BigDecimal flowerPrice;

	public Flower(String flowerID, String flowerName, String flowerDescription, BigDecimal flowerPrice) {
		super();
		this.flowerID = flowerID;
		this.flowerName = flowerName;
		this.flowerDescription = flowerDescription;
		this.flowerPrice = flowerPrice;
	}

	public String getFlowerID() {
		return flowerID;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public String getFlowerDescription() {
		return flowerDescription;
	}

	public BigDecimal getFlowerPrice() {
		return flowerPrice;
	}

	public void setFlowerID(String flowerID) {
		this.flowerID = flowerID;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public void setFlowerDescription(String flowerDescription) {
		this.flowerDescription = flowerDescription;
	}

	public void setFlowerPrice(BigDecimal flowerPrice) {
		this.flowerPrice = flowerPrice;
	}

}
