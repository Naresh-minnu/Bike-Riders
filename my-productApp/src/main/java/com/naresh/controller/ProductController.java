package com.naresh.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.model.Product;
import com.naresh.service.ProductService;

@Controller
@Validated
@CrossOrigin
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer numberOfRecords,
			@RequestParam(required = false, value = "pid") Integer pid, @RequestParam(value="name",required=false) String name) {

		if (pageNumber != null && numberOfRecords != null) {
			List<Product> list = productService.findByPagination(pageNumber, numberOfRecords);
			return ResponseEntity.status(200).body(list);
		}

		List<Product> listOfProduct = productService.findByAll();
		return ResponseEntity.status(200).body(listOfProduct);
	}

	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getProduct(
			@NonNull @Positive(message = "id should be positive") @PathVariable("pid") Integer pid) {
		Product product = productService.getProduct(pid);
		return ResponseEntity.status(200).body(product);

	}

	@PostMapping("/products")
	public ResponseEntity<Product> createEmployee(@Valid @RequestBody Product product) {
		Product product1 = productService.createProduct(product);
		return ResponseEntity.status(201).body(product1);
	}

	@RequestMapping(value = "/products/{pid}", method = RequestMethod.PUT)
	public ResponseEntity<Product> createProduct(@RequestBody Product product, @PathVariable("pid") Integer pid) {
		Product product1 = productService.updateProduct(pid, product);
		return ResponseEntity.status(200).body(product1);

	}

	@DeleteMapping("/products/{pid}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("pid") Integer pid) {
		productService.deleteProduct(pid);
		return ResponseEntity.status(204).body(null);
	}
}
