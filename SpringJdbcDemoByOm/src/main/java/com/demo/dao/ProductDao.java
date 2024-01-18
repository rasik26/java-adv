package com.demo.dao;

import java.util.List;

import com.demo.model.Product11;

public interface ProductDao {

	int save(Product11 p);

	List<Product11> findAll();

	Product11 findById(int pid);

	List<Product11> findByQty(int qty);

	int deletById(int pid);

	int updateById(int pid, int qty, double pr);

}