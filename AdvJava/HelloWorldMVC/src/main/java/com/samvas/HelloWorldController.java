package com.samvas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController 
{

	@RequestMapping("/welcome")
	public String showHello(@RequestParam("name") String name,Model model)
	{
		
		
		model.addAttribute("msg", "welcome  "+name);
//		return which view it should be redirected at
		return "home";
		
	}
		
}
