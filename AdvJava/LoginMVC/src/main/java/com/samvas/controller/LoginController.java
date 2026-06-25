package com.samvas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	/*
	 * In index.jsp we use the request.sendRedirect("login");
	 * This maps here to Controller
	 */
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/validate")
	public String validateLogin(@RequestParam("username") String uname, @RequestParam("password") String pass) {
		if(uname.equals("admin") && pass.equals("admin123")) {
			return "success";
		}
		else{
			return "Failure";
		}
	}
	
	
}
