package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;
import com.demo.model.Project;
public class ManyToManyTest {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee(1,"Anglina",40000);
		Employee emp2 = new Employee(2,"Ramika",40000);
		Employee emp3 = new Employee(3,"Rockky",678000);
		Employee emp4 = new Employee(4,"Babbar",90000);
		
		Set<Employee> eset1= new HashSet<Employee>();
		
		eset1.add(emp1);
		eset1.add(emp2);
		eset1.add(emp3);
		
        Set<Employee> eset2= new HashSet<Employee>();
		
        eset1.add(emp2);
		eset1.add(emp3);
		eset2.add(emp4);
		
		Project p1= new Project(105,"SmartPark",eset1);
		Project p2= new Project(205,"AirAgriculture",eset2);
		
		Set<Project> pset1 = new HashSet<Project>();
		pset1.add(p1);
		Set<Project> pset2 = new HashSet<Project>();
		pset2.add(p2);
		Set<Project> pset3 = new HashSet<Project>();
		pset3.add(p1);
		pset3.add(p2);
		
		p1.setEset(eset1);
		p2.setEset(eset2);
		
		emp1.setPset(pset1);
		emp2.setPset(pset3);
		emp3.setPset(pset3);
		emp4.setPset(pset2);
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		
		tr.commit();
		session.close();
		sf.close();
		
	}

}
