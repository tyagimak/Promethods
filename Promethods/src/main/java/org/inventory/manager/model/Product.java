package org.inventory.manager.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Repository
public class Product {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "ProductName")
	private String name;
	@Column(name = "ProductCompany")
	private String company;
	@Column(name = "ProductCategory")
	private String type;
	@Column(name = "BuyingPrice")
	private long buyPrice;
	@Column(name = "SellingPrice")
	private long sellingPrice;
	@Column(name = "Quantity")
	private long quantity;
	
	

	public Product() {
		super();
	}

	public Product(String name, String type, String company, long buyPrice, long sellingPrice, long quantity) {
		super();
		this.name = name;
		this.type = type;
		this.company = company;
		this.buyPrice = buyPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public long getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(long buyPrice) {
		this.buyPrice = buyPrice;
	}

	public long getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(long sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
