package org.inventory.manager.model;

import java.util.Date;
import java.util.List;

public class Order {

	private long orderId;
	private List<Product> productList;
	private Date timestamp;
	private long orderAmount;

	public long getOrderId() {
		return orderId;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public long getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(long orderAmount) {
		this.orderAmount = orderAmount;
	}

}
