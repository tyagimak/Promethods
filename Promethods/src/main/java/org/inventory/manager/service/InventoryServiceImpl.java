package org.inventory.manager.service;

import java.util.List;

import org.inventory.manager.model.Product;
import org.inventory.manager.rep.InventoryServiceDao;
import org.inventory.manager.rep.InventoryServiceDaoImpl;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService{

	private InventoryServiceDao inventoryServicedao ;
	
	public InventoryServiceImpl() {
		super();
		this.inventoryServicedao = new InventoryServiceDaoImpl();
	}

	@Override
	public Product getProduct(long id) {
		return inventoryServicedao.getProduct(id);
	}

	@Override
	public List<Product> getProductList() {
		return inventoryServicedao.getAllProduct();
	}

	@Override
	public void removeProduct(long id) {
		inventoryServicedao.removeProduct(id);		
	}

	@Override
	public void changeBuyingPrice(long id, long newPrice) {
		Product product = inventoryServicedao.getProduct(id);
		product.setBuyPrice(newPrice);
		inventoryServicedao.updateProduct(product);
	}

	@Override
	public void changeSellingPrice(long id, long newPrice) {
		Product product = inventoryServicedao.getProduct(id);
		product.setSellingPrice(newPrice);
		inventoryServicedao.updateProduct(product);
	}

	@Override
	public void updateQuantity(long id, long quantity) {
		Product product = inventoryServicedao.getProduct(id);
		product.setQuantity(quantity);
		inventoryServicedao.updateProduct(product);
	}

}
