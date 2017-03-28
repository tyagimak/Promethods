package org.inventory.manager.interaction;

import java.util.ArrayList;
import java.util.List;

import org.inventory.manager.model.Product;
import org.inventory.manager.service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PromethodController {

	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	
	@RequestMapping(value="/inventory",method=RequestMethod.GET,produces="application/json")
	public String getInventory(Model model){
		model.addAttribute("message", "There is no product in inventory currently!! update the stock");
		return "inventorypage";
	}
	
	@RequestMapping(value = "/getproduct", method = RequestMethod.GET)
	//@ResponseBody()
	public String getAllProducts(Model model) {
		List<Product> productList = getproductList();
		model.addAllAttributes(productList);
		return "inventorypage";
	}

	private List<Product> getproductList() {
		List<Product> list = new ArrayList<>();
		list.add(new Product("abc", "a", "xyz labs", 2000, 2500, 2));
		list.add(new Product("bcd", "b", "yz labs", 1000, 1500, 5));
		return list;
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET, produces = "application/json")
	public String getProductDetails(@PathVariable("id") long id, Model model) {
		Product product = inventoryServiceImpl.getProduct(id);
		model.addAttribute(product);
		return "product";
	}
	
}
