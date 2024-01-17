package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;

	public int insert(Product p) {
		return pdao.save(p);
	}

	public List<Product> showAll() {
		return pdao.getAll();
	}

	public int delById(int pid) {
		return pdao.deleteById(pid);
	}

	public int upById(Product p) {
		return pdao.updateById(p);
	}

	public Product showById(int pid) {
		return pdao.getById(pid);
	}
}
