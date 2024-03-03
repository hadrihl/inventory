package com.example.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.inventory.entity.Product;
import com.example.inventory.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String getProductsPage(Model model) {
		List<Product> products = productService.getAllProducts();
		
		model.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/products/new")
	public String getProductPage() {
		return "product-new";
	}
	
	@PostMapping("/products/new")
	public String createProduct(Model model, @ModelAttribute("product") Product product) {
		productService.addNewProduct(product);
		
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "redirect:/products";
	}
	
	@GetMapping("/products/{id}")
	public String getProductDetails(Model model, @PathVariable("id") Long id) {
		Product product = productService.getProductDetails(id);
		
		model.addAttribute("id", id);
		model.addAttribute("product", product);
		return "product";
	}
	
	@PostMapping("/products/{id}")
	public String updateProductDetails(Model model, @PathVariable("id") Long id, @ModelAttribute("product") Product product) {
		System.out.println(product.getName());
		Product savedProduct = productService.updateProductDetails(id, product);
		model.addAttribute("product", savedProduct);
		model.addAttribute("msg", "Product details are updated successfully.");
		return "product";
	}
	
	@GetMapping("products/{id}/delete")
	public String deleteProductDetails(Model model, @PathVariable("id") Long id) {
		productService.removeProduct(id);
		
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "redirect:/products";
	}

}