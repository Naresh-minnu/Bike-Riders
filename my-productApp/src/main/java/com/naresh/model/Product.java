package com.naresh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private int pid;

	@Column(name="PRODUCT_CATEGORY")
	private String category;

	@Column(name="PRODUCT_NAME")
	private String name;

	@Column(name="PRICE")
	private String price;

	@Column(name="STOCKED")
	private boolean stocked;
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStocked() {
		return stocked;
	}

	public void setStocked(boolean stocked) {
		this.stocked = stocked;
	}

}

