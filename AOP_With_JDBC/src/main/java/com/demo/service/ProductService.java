package com.demo.service;
import java.util.List;
import com.demo.model.*;

public interface ProductService {
	
	int insert();
	List<Product> showAll();
	int delById();
	int upById();
	Product getById();
}
