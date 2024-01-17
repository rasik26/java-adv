package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;
import com.demo.model.Project;


public class RetriveData {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session s1= sf.openSession();
		Transaction tr = s1.beginTransaction();
		Project p= s1.get(Project.class, 201);
		System.out.println(p);
		
		Employee e= s1.get(Employee.class, 3);
		System.out.println(e);
		tr.commit();
		s1.close();
		sf.close();
		
	}

}
