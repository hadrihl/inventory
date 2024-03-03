package com.example.inventory.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public Product getProductDetails(Long id) {
		return productRepository.findById(id).get();
	}
	
	public Product updateProductDetails(Long id, Product product) {
		Product tmp = new Product();
		tmp.setId(id);
		tmp.setName(product.getName());
		tmp.setDescription(product.getDescription());
		tmp.setPpu(product.getPpu());
		tmp.setCategory(product.getCategory());
		tmp.setQuantity(product.getQuantity());
		
		return productRepository.save(tmp);
	}
	
	public void removeProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	public Product addNewProduct(Product product) {
		Product savedProduct = new Product();
		savedProduct.setName(product.getName());
		savedProduct.setDescription(product.getDescription());
		savedProduct.setCategory(product.getCategory());
		savedProduct.setPpu(product.getPpu());
		savedProduct.setQuantity(product.getQuantity());
		
		return productRepository.save(savedProduct);
	}
}