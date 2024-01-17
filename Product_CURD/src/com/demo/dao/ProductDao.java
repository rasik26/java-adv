package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {
	List<Product> getProduct();
	Product getProductById(int id);
	boolean insertProduct(Product p);
	boolean delByID(int id);
	boolean upByID(int id, String desc);
}
