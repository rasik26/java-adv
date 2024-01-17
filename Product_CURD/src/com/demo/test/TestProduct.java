package com.demo.test;
import com.demo.beans.Product;
import com.demo.services.*;

import java.util.List;
import java.util.Scanner;
public class TestProduct {

	public static void main(String[] args) {
		ProductServices psrvc = new ProductServicesImpl();
		Scanner Sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("==============================");
			System.out.println("0. Exit");
			System.out.println("1. Display Product List");
			System.out.println("2. Display Product By ID");
			System.out.println("3. Insert Product");
			System.out.println("4. Delete Product By ID");
			System.out.println("5. Update Product By ID");
			System.out.println("------------------------------");
			System.out.println("Enter Choice : ");
			choice = Sc.nextInt();
			switch(choice) {
			case 0: System.exit(0);
			
			case 1: List<Product>p_list = psrvc.getAll();
					for(int i=0; i<p_list.size(); i++)
					{
						System.out.println(p_list.get(i));
					}
					break;
					
			case 2: System.out.println("Enter Product ID : ");
					int id = Sc.nextInt();
					System.out.println(psrvc.showById(id));
					break;
					
			case 3: System.out.println("Enter Product ID : ");
					int pid = Sc.nextInt();
					Sc.nextLine();
					System.out.println("Enter Product Description : ");
					String desc = Sc.nextLine();
					Product tmp_p = new Product(pid, desc);
					if(psrvc.addProduct(tmp_p));
						System.out.println("Item Added SuccessFully !!");
					break;
					
			case 4: System.out.println("Enter Product ID : ");
					pid = Sc.nextInt();
					if(psrvc.delProductById(pid))
						System.out.println("Product Deleted SuccessFully !!");
					break;
					
			case 5: System.out.println("Enter Product ID : ");
					pid = Sc.nextInt();
					Sc.nextLine();
					System.out.println("Enter Product Description to Update : ");
					desc = Sc.nextLine();
					if(psrvc.updateProductById(pid, desc))
							System.out.println("Updated SuccessFully !!");
					break;
					
			default:System.out.println("Thank You !!");
			}
		}while(choice!=0);
	}

}
