package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Product;
import com.demo.service.*;

import java.util.List;
import java.util.Scanner;
public class TestSprigJDBC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		ApplicationContext actx = new ClassPathXmlApplicationContext("springconfig.xml");
		ProductService psrvc = (ProductServiceImpl)actx.getBean("productServiceImpl");
		do {
			System.out.println("1. Insert Product");
			System.out.println("2. Show Products");
			System.out.println("3. Delete Product By ID");
			System.out.println("4. Update Product By ID");
			System.out.println("5. Show Product By ID");
			System.out.println("0. Exit");
			System.out.println("Enter Choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 0: System.out.println("Thank you");
			
			case 1: 
				if(psrvc.insert() > 0)
					System.out.println("Product Inserted Successfully");
				break;
				
			case 2:
				List<Product> plist = psrvc.showAll();
				for(Product p: plist) {
					System.out.println(p);
				}
				break;
				
			case 3: 
				if(psrvc.delById() > 0)
					System.out.println("Product Deleted Successfully");
				break;
				
			case 4:
				if(psrvc.upById() > 0)
					System.out.println("Product Updated Successfully");
				break;
				
			case 5:
				Product p = psrvc.getById();
				if(p != null)
					System.out.println(p);
				else 
					System.out.println("Product Not Found");
				break;	
			}		
		}while(choice != 0);
	}
}
