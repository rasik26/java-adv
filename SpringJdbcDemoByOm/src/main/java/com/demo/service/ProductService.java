package com.demo.service;

import java.util.List;

import com.demo.model.Product11;

public interface ProductService {

	int addnewProduct();

	List<Product11> getAll();

	Product11 getById(int pid);

	List<Product11> getByQty(int qty);

	int deleteById(int pid);

	int modifyById(int pid, int qty, double pr);

}