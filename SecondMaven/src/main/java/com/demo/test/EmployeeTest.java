package com.demo.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee(1,"Raik",35765);
		Employee e2=new Employee(2,"Rai$k",35762);
		Employee e3=new Employee(3,"RaiSk",35763);
		Employee e4=new Employee(4,"Raisk",35764);
		
		
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        Session session=sf.openSession();
        Transaction tr=session.beginTransaction();
        
        session.save(e1);
        session.save(e3);
        session.save(e2);
        session.save(e4);
        
        tr.commit();
       //System.out.println(e1);
        session.close();
        
       
        
	}

}
