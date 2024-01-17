package com.demo.services;

import java.util.List;
import com.demo.beans.*;
public interface ProductServices {
	List<Product> getAll();
	Product showById(int id);
	boolean addProduct(Product p);
	boolean delProductById(int id);
	boolean updateProductById(int id, String desc);
}
