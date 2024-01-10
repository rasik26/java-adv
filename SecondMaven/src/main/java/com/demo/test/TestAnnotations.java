package com.demo.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Product;
public class TestAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product p1 = new Product( "apple", 1234, 2);
		Product p2 = new Product( " banana", 12, 254);
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session= sf.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(p1);
		session.save(p2);
		tr.commit();
		session.close();
		sf.close();
		
	}

}
