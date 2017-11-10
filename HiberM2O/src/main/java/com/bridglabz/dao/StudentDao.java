package com.bridglabz.dao;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bridgelabz.model.Student;
import com.bridgelabz.model.Subject;




public class StudentDao {
	private static final SessionFactory sessionFactory;
	public static Scanner scanner=new Scanner(System.in);
	public  static Student student=new Student();
	public static Subject subject=new Subject();
	public static Subject []subjectarray;
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
	
	
	 
	 public void insert(){
		   SessionFactory sessionFactory = StudentDao.getSessionFactory();

		   Session session = sessionFactory.openSession();
		
		   session.beginTransaction();
		   scanner.nextLine();
		   System.out.println("enter students name");
		  student.setName(scanner.nextLine());
	
		 
	
		   System.out.println("enter no of subject");
		   int number=scanner.nextInt();
		   scanner.nextLine();
		   subjectarray=new Subject[number];
		   for(int i=0;i<number;i++) {
			   subject=new Subject();
			   System.out.println("enter subjects name");
			   subject.setName(scanner.nextLine());
			  subject.setUsername(student);
			   session.save(subject);
			 
		   }
		
		
		   session.save(student);
		  
		  
		   System.out.println("Inserted Successfully");
		   session.getTransaction().commit();
		   session.close();
		 
	   }
	   public void update() {
		   SessionFactory sessionFactory = StudentDao.getSessionFactory();
		   scanner.nextLine();
		   Session session = sessionFactory.openSession();
		   System.out.println("enter first name");
		   String firstname=scanner.nextLine();
		   System.out.println("enter id");
		   int id=scanner.nextInt();
		   
		
		   session.beginTransaction();
		student = session.get(Student.class, id);
		 student.setName(firstname);
		   System.out.println("Updated Successfully");
		   session.getTransaction().commit();
		session.close();
	   }
	   
	   
	   public void delete(){
		   scanner.nextLine();
		   System.out.println("enter the id for deletion");
		int id=scanner.nextInt();
		   SessionFactory sessionFactory =StudentDao.getSessionFactory();
	
		   Session session = sessionFactory.openSession();
		 
		   session.beginTransaction();
		   
		student = session.load(Student.class, id);
	
		   session.delete(student);
		   System.out.println("Deleted Successfully");
		   session.getTransaction().commit();
		   session.close();
		   
		  }
	   
	   public void display() {
		   SessionFactory sessionFactory =StudentDao.getSessionFactory();
		   //getting session object from session factory
		   Session session = sessionFactory.openSession();
		   //getting transaction object from session object
		   session.beginTransaction();
		   Query<Subject> query = session.createQuery("from Subject");
		   List<Subject> subjects = query.getResultList();
		
		  for(Subject subject :subjects)
		  {
		//Student student1=subject.getUsername();
		System.out.println(/*student.getName()+*/" "+subject.getName());
		

		   }
		   session.getTransaction().commit();
		   session.close();
		   
		   
		  }

}


