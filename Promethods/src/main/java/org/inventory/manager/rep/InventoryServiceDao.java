package org.inventory.manager.rep;

import java.util.List;

import org.inventory.manager.model.Product;

public interface InventoryServiceDao {

	public String addProduct(Product product);
	
	public void removeProduct(long id);
	
	public void updateProduct(Product product);
	
	public Product getProduct(long id);
	
	public List<Product> getAllProduct();
	
	public void removeBulkProduct(List<Long> idList );
}
