package com.mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppRunnerone {
	@RequestMapping("/TestRun")
	public ModelAndView testRun(){
		String val = "result";
		String message = "test running";
		return new ModelAndView(val,"message",message);
	}
}
