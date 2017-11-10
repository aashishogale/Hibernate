package com.bridgelabz.util;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.bridgelabz.programs.Employee1;

public class EmployeeDao {
	private static final SessionFactory sessionFactory;
	public static Scanner scanner=new Scanner(System.in);
	public  static  Employee1 employee1=new Employee1();
	 static
	 {
	  try
	  {
	   sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	  }
	  catch(Throwable th){
	   System.err.println("Enitial SessionFactory creation failed"+th);
	   throw new ExceptionInInitializerError(th);
	  }
	   }
	   public static SessionFactory getSessionFactory(){
	    return sessionFactory;
	   }
	
	   
	   public  void getObject() {
		   scanner.nextLine();
		   System.out.println("enter firstname");
		   employee1.setFirstname(scanner.nextLine());
		   System.out.println("enter lastname");
		   employee1.setLastname(scanner.nextLine());
		   System.out.println("enter salary");
		   employee1.setSalary(scanner.nextInt());
		   
		    }
	   
	   public void insert(){
		   SessionFactory sessionFactory = EmployeeDao.getSessionFactory();

		   Session session = sessionFactory.openSession();
		
		   session.beginTransaction();
		   session.save(employee1);
		   System.out.println("Inserted Successfully");
		   session.getTransaction().commit();
		   session.close();
		   sessionFactory.close();
	   }
	   public void update() {
		   SessionFactory sessionFactory = EmployeeDao.getSessionFactory();
		   scanner.nextLine();
		   Session session = sessionFactory.openSession();
		   System.out.println("enter first name");
		   String firstname=scanner.nextLine();
		   System.out.println("enter last name");
		   int id=scanner.nextInt();
		   
		
		   session.beginTransaction();
		employee1 = (Employee1)session.get(Employee1.class, id);
		 employee1.setFirstname(firstname);
		   System.out.println("Updated Successfully");
		   session.getTransaction().commit();
		   sessionFactory.close();
	   }
	   
	   
	   public void delete(){
		   scanner.nextLine();
		   System.out.println("enter the id for deletion");
		int id=scanner.nextInt();
		   SessionFactory sessionFactory =EmployeeDao.getSessionFactory();
	
		   Session session = sessionFactory.openSession();
		 
		   session.beginTransaction();
		   
		employee1 = (Employee1)session.load(Employee1.class, id);
		   session.delete(employee1);
		   System.out.println("Deleted Successfully");
		   session.getTransaction().commit();
		      sessionFactory.close();
		  }
	   
	   public void display() {
		   SessionFactory sessionFactory =EmployeeDao.getSessionFactory();
		   //getting session object from session factory
		   Session session = sessionFactory.openSession();
		   //getting transaction object from session object
		   session.beginTransaction();
		   Query query = session.createQuery("from Employee1");
		   List<Employee1> employees = query.list();
		   for(Employee1 employee : employees)
		   {
		 System.out.println(employee.getFirstname());
		   }
		   session.getTransaction().commit();
		   sessionFactory.close();
		  }
	   
	   
	   

}
