package com.naresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.naresh.model.Product;
import com.naresh.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {

		return productRepository.save(product);
	}

	public Product getProduct(Integer pid) {
		Optional<Product> product = productRepository.findById(pid);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	public Product updateProduct(Integer pid, Product product) {
		product.setPid(pid);
		return productRepository.save(product);

	}

	public void deleteProduct(Integer pid) {

		productRepository.deleteById(pid);
	}

	public List<Product> findByAll() {

		return productRepository.findAll();
	}

	public List<Product> findByPagination(int pageNumber, int numberOfRecords) {
		PageRequest page = PageRequest.of(pageNumber, numberOfRecords);
		Page<Product> pageData = productRepository.findAll(page);
		return pageData.getContent();
	}


}
