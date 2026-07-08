package com.samvas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.samvas.model.Product;
import com.samvas.repository.ProductRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository prod_repo;
	
	
//	READ ALL (DASHBOARD VIEW)
	@GetMapping
	public String showDashboard(Model model) {
		model.addAttribute("products", prod_repo.findAll());
		return "index";
	}
	
//  SHOW CREATE FORM
	@GetMapping("/new")
	public String showCreateForm(Model model) {
		// Binds an empty structural wrapper
		model.addAttribute("product", new Product());
		return "product-form";
	}
	
//	PROCESS CREATE / UPDATE SAVE
	@PostMapping("/save")
//	BindingResult result
	public String saveProdcut(@Valid @ModelAttribute("product") Product product_obj) {
//		if(result.hasErrors())
//			return "product-form";
		prod_repo.save(product_obj);
		return "redirect:/products";
	}
	
//	SHOW EDIT FORM (PRE-POPULATED)
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Product product = prod_repo.findById(id)
				.orElseThrow( () -> new IllegalArgumentException("Invalid product Id:" + id) );
		model.addAttribute("product", product);
		return "product-form";
	}
	
//	PROCESS DELETE
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		prod_repo.deleteById(id);
		return "redirect:/products";
	}
}
