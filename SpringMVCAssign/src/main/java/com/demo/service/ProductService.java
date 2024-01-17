package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {
	int insert(Product p);
	List<Product> showAll();
	int delById(int pid);
	int upById(Product p);
	Product showById(int pid);
}
