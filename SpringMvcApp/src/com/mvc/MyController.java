package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/view")
	public ModelAndView view1(){
		String message = "Encoded Message";
		return new ModelAndView("view","message",message);
	}
}


