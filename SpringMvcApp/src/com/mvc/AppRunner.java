package com.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppRunner {
	String val;
	@RequestMapping(value = "/loginPage", params = {"firstname","password"})
	public ModelAndView login(@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "password")String password) throws FileNotFoundException{
		val = "result";
		String message = "Try Again";
		JSONParser parser = new JSONParser();
		
		try {     
			Object obj = parser.parse(new FileReader("D:/java/input/userDetail.json"));

			JSONObject jsonObject =  (JSONObject) obj;

			String name = (String) jsonObject.get("LoginId");
			String passkey = (String) jsonObject.get("Password");
			
			if(passkey.equals(password)&&name.equals(firstname)){
				val = "home";
				message = "Login SuccessFul";
			}

		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return new ModelAndView(val,"message",message);
	}

	@RequestMapping("/loginPage")
	public ModelAndView loginPage(){
		return new ModelAndView("loginPage");
	}

	@RequestMapping(value = "/loginPage", params = {"firstname","lastname","password","age"})
	public ModelAndView login(@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname,
			@RequestParam(value= "password") String password ,
			@RequestParam(value = "age") String age) throws IOException{
		String message = "";
		

		FileWriter f1 = new FileWriter(new File("D:/java/output/Data.tsv"));
		f1.write(firstname+"	"+lastname+"	"+age+"	"+password);
		f1.close();
		return new ModelAndView("result","message",message);

	}

	@RequestMapping("/cal")
	public  ModelAndView calpage(){
		return new ModelAndView("calpage");
	}

	@RequestMapping(value = "/cal", params = {"num1","num2"})
	public ModelAndView calculator(
			@RequestParam(value= "num1") int num1,
			@RequestParam(value = "num2") int num2) throws IOException{
		int sum = num1 + num2 ;

		return new ModelAndView("calpage","sum",sum);

	}		
}

