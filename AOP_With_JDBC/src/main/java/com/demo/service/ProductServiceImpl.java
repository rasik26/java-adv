package com.demo.service;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;
	Scanner sc = new Scanner(System.in);
	public int insert() {
		System.out.println("Enter ID : ");
		int id = sc.nextInt();
		System.out.println("Enter Name : ");
		String name = sc.next();
		System.out.println("Enter Price : ");
		double price = sc.nextDouble();
		System.out.println("Enter Quantity : ");
		int qty = sc.nextInt();
		Product p = new Product(id, name, price, qty); 
		return pdao.save(p);
	}

	public List<Product> showAll() {
		return pdao.getAll();
	}

	public int delById() {
		System.out.println("Enter ID To Delete Product : ");
		int id = sc.nextInt();
		return pdao.deletById(id);
	}

	public int upById() {
		System.out.println("Enter ID To Update Product : ");
		int id = sc.nextInt();
		System.out.println("Enter Quantity : ");
		int qty = sc.nextInt();
		return pdao.updateById(id, qty);
	}

	public Product getById() {
		System.out.println("Enter ID To Get Product : ");
		int id = sc.nextInt();
		return pdao.findById(id);
	}

}
