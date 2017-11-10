package com.bridgelabz.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bridelabz.model.Doctor;
import com.bridelabz.model.Patient;







public class DoctorDao {
	private static final SessionFactory sessionFactory;
	public static Scanner scanner=new Scanner(System.in);
	public  static Doctor doctor=new Doctor();
	public static Patient patient=new Patient();
	
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
public void insertDoctor() {
	   SessionFactory sessionFactory = DoctorDao.getSessionFactory();

	   Session session = sessionFactory.openSession();
	
	   session.beginTransaction();

	 
	 Collection<Patient> patientlist=new HashSet<Patient>();
	   System.out.println("enter no of patient");
	   int number=scanner.nextInt();
	   scanner.nextLine();

	   for(int i=0;i<number;i++) {
		   patient=new Patient();
		   System.out.println("enter patients name");
		   patient.setName(scanner.nextLine());
		   System.out.println("enter adrress");
		   patient.setAddress(scanner.nextLine());
		
		   patientlist.add(patient);
		   session.save(patient);
	   }
	   
	   System.out.println("enter no of doctor");
	  number=scanner.nextInt();
	   scanner.nextLine();
	   for(int i=0;i<number;i++) {
		   scanner.nextLine();
		   doctor=new Doctor();
		   System.out.println("enter doctors name");
		  doctor.setName(scanner.nextLine());
		   System.out.println("enter speciality");
		 doctor.setSpeciality(scanner.nextLine());
	   doctor.setPatient(patientlist);
	   
	   session.save(doctor);
	
	   }
	  
	  
	   System.out.println("Inserted Successfully");
	   session.flush();
	   session.getTransaction().commit();
	   session.close();
	 
   }
public void insertPatient() {
	   SessionFactory sessionFactory = DoctorDao.getSessionFactory();

	   Session session = sessionFactory.openSession();
	
	   session.beginTransaction();
	   scanner.nextLine();
	   System.out.println("enter patients name");
	   patient.setName(scanner.nextLine());
	   System.out.println("enter adrress");
	   patient.setAddress(scanner.nextLine());
	   Collection<Doctor> doctorlist=new HashSet<Doctor>();
	   scanner.nextLine();
	   System.out.println("enter no of doctor");
	   int number=scanner.nextInt();
	   scanner.nextLine();
	   for(int i=0;i<number;i++) {
		  doctor=new Doctor();
		   System.out.println("enter doctors name");
			  doctor.setName(scanner.nextLine());
			   System.out.println("enter speciality");
			 doctor.setSpeciality(scanner.nextLine());
		   session.save(doctor);
	   
		   doctorlist.add(doctor);
	   }
	   patient.setDoctor(doctorlist);
	   session.save(patient);
	   System.out.println("Inserted Successfully");
	   session.getTransaction().commit();
	   session.close();
	
}
public void update() {
	   SessionFactory sessionFactory = DoctorDao.getSessionFactory();
	   scanner.nextLine();
	   Session session = sessionFactory.openSession();
	   System.out.println("enter first name");
	   String firstname=scanner.nextLine();
	   System.out.println("enter last name");
	   int id=scanner.nextInt();
	   
	
	   session.beginTransaction();
	doctor = session.get(Doctor.class, id);
	 doctor.setName(firstname);
	   System.out.println("Updated Successfully");
	   session.getTransaction().commit();
	session.close();
}


public void delete(){
	   scanner.nextLine();
	   System.out.println("enter the id for deletion");
	int id=scanner.nextInt();
	   SessionFactory sessionFactory =DoctorDao.getSessionFactory();

	   Session session = sessionFactory.openSession();
	 
	   session.beginTransaction();
	   
	doctor = session.load(Doctor.class, id);

	   session.delete(doctor);
	   System.out.println("Deleted Successfully");
	   session.getTransaction().commit();
	   session.close();
	   
	  }

public void display() {
	   SessionFactory sessionFactory =DoctorDao.getSessionFactory();
	   //getting session object from session factory
	   Session session = sessionFactory.openSession();
	   //getting transaction object from session object
	   session.beginTransaction();
	   Query<Doctor> query = session.createQuery("from Doctor");
	   List<Doctor> doctors = query.getResultList();
	 		 
	   for(Doctor doctor :doctors)
	   {
	 System.out.println(doctor.getName()+doctor.getSpeciality());
	   }
	   session.getTransaction().commit();
	   session.close();
	   
	   
	  }

}

