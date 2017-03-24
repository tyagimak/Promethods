package org.inventory.manager.interaction;

import java.util.List;

import org.inventory.manager.model.Product;
import org.inventory.manager.service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PromethodController {

	@RequestMapping(value="/inventory")
	public String getInventory(Model model){
		model.addAttribute("message", "There is no product in inventory currently!! update the stock");
		return "inventorypage";
	}
	
	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody()
	public String getAllProducts(Model model) {
		List<Product> productList = inventoryServiceImpl.getProductList();
		model.addAllAttributes(productList);
		return "homepage";
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getProductDetails(@PathVariable("id") long id, Model model) {
		Product product = inventoryServiceImpl.getProduct(id);
		model.addAttribute(product);
		return "product";
	}
	
}
