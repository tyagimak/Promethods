package org.inventory.manager.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PromethodController {

	@RequestMapping(value="/inventory")
	public String getInventory(Model model){
		model.addAttribute("message", "There is no product in inventory currently!! update the stock");
		return "inventorypage";
	}
	
}
