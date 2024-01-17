package com.demo.services;

import java.util.List;
import java.util.Scanner;
import com.demo.beans.Product;
import com.demo.dao.ProductDaoImpl;

public class ProductServicesImpl implements ProductServices{
	private ProductDaoImpl pdao;
	public ProductServicesImpl() {
		pdao = new ProductDaoImpl();
	}
	@Override
	public List<Product> getAll() {
		return pdao.getProduct();
	}

	@Override
	public Product showById(int id) {
		return pdao.getProductById(id);
	}

	@Override
	public boolean addProduct(Product p) {
		return pdao.insertProduct(p);
		
	}
	@Override
	public boolean delProductById(int id) {
		return pdao.delByID(id);
	}
	@Override
	public boolean updateProductById(int id, String desc) {
		return pdao.upByID(id, desc);
	}
	
}
