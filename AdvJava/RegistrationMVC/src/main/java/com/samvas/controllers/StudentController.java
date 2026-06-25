package com.samvas.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
ArrayList<Student> al = new ArrayList<>();

	
	
	@GetMapping("/register")
	public String registerStudent()
	{
		return "register";
	}
	
	
	
	@PostMapping("/save")
	public String saveStudent(
			@RequestParam("id") String id,
			@RequestParam("name")   String name,
			@RequestParam("course") String course,
			Model model)
	{
		
		Student s = new Student(Integer.parseInt(id),name,course);
		al.add(s);
 	
		return "success";
	}
	
	@GetMapping("/view")
	public String viewStudent(Model model)
	{
		model.addAttribute("students" ,al);
		
		return "viewStudents";
	}

}
