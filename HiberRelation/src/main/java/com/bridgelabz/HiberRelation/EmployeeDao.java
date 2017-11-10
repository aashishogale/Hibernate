package com.bridgelabz.HiberRelation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;





public class EmployeeDao {
	private static final SessionFactory sessionFactory;
	public static Scanner scanner=new Scanner(System.in);
	public  static  Employee employee1=new Employee();
	public static Position position=new Position();
	 static
	 {
	  try
	  {
	   sessionFactory = new Configuration().configure().buildSessionFactory();
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
		   employee1.setName(scanner.nextLine());
		   System.out.println("enter position");
		   position.setPosition(scanner.nextLine());
		   System.out.println("enter salary");
		   position.setSalary(scanner.nextInt());
		   scanner.nextLine();
		   System.out.println("enter adrress");
		   employee1.setAddress(scanner.nextLine());
		   employee1.setPosition(position);
	
		   
		    }
	   
	   public void insert(){
		   SessionFactory sessionFactory = EmployeeDao.getSessionFactory();

		   Session session = sessionFactory.openSession();
		
		   session.beginTransaction();
		   session.save(position);
		   session.save(employee1);
		   System.out.println("Inserted Successfully");
		   session.getTransaction().commit();
		   session.close();
		 
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
		employee1 = session.get(Employee.class, id);
		 employee1.setName(firstname);
		   System.out.println("Updated Successfully");
		   session.getTransaction().commit();
		session.close();
	   }
	   
	   
	   public void delete(){
		   scanner.nextLine();
		   System.out.println("enter the id for deletion");
		int id=scanner.nextInt();
		   SessionFactory sessionFactory =EmployeeDao.getSessionFactory();
	
		   Session session = sessionFactory.openSession();
		 
		   session.beginTransaction();
		   
		employee1 = session.load(Employee.class, id);
	
		   session.delete(employee1);
		   System.out.println("Deleted Successfully");
		   session.getTransaction().commit();
		   session.close();
		   
		  }
	   
	   public void display() {
		   SessionFactory sessionFactory =EmployeeDao.getSessionFactory();
		   //getting session object from session factory
		   Session session = sessionFactory.openSession();
		   //getting transaction object from session object
		   session.beginTransaction();
		   Query<Employee> query = session.createQuery("from Employee");
		   List<Employee> employees = query.getResultList();
		 		 
		   for(Employee employee : employees)
		   {
		 System.out.println(employee.getName()+employee.getAddress());
		   }
		   session.getTransaction().commit();
		   session.close();
		   
		   
		  }
	   
	   
	   
}
