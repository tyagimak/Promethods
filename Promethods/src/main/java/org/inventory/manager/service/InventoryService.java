package org.inventory.manager.service;

import java.util.List;

import org.inventory.manager.model.Product;

public interface InventoryService {

	public Product getProduct(long id);
	
	public List<Product> getProductList();
	
	public void removeProduct(long id);
	
	public void changeBuyingPrice(long id, long newPrice);
	
	public void changeSellingPrice(long id, long newPrice);
	
	public void updateQuantity(long id, long quantity);
}
