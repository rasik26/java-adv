package com.demo.dao;
import java.util.List;

import com.demo.model.*;
public interface ProductDao {
	int save (Product p);
	List<Product> getAll();
	Product findById(int pid);
	int deletById(int pid);
	int updateById(int pid, int qty);
}
