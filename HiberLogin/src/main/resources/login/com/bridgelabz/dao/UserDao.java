package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bridgelabz.model.User;

public class UserDao {

	private static final SessionFactory sessionFactory;
	public static Scanner scanner = new Scanner(System.in);
	public static User user = new User();

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable th) {
			System.err.println("Enitial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void insert(User user) {
		SessionFactory sessionFactory = UserDao.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();
		;
		session.save(user);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		session.close();

	}

	public void update() {
		SessionFactory sessionFactory = UserDao.getSessionFactory();
		scanner.nextLine();
		Session session = sessionFactory.openSession();
		System.out.println("enter first name");
		String firstname = scanner.nextLine();
		System.out.println("enter last name");
		int id = scanner.nextInt();

		session.beginTransaction();
		user = session.get(User.class, id);
		user.setName(firstname);
		System.out.println("Updated Successfully");
		session.getTransaction().commit();
		session.close();
	}

	public void delete() {
		scanner.nextLine();
		System.out.println("enter the id for deletion");
		int id = scanner.nextInt();
		SessionFactory sessionFactory = UserDao.getSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		user = session.load(User.class, id);

		session.delete(user);
		System.out.println("Deleted Successfully");
		session.getTransaction().commit();
		session.close();

	}


	public boolean checkUser(String email, String password) {
		SessionFactory sessionFactory = UserDao.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		Query<User> query = session.createQuery("from User");
		List<User> users = query.getResultList();

		for (User user : users) {
		if(user.getEmail().equals(email)&&user.getPassword().equals(password)){
			return true;
		}
		
		
		}
		
		session.getTransaction().commit();
		session.close();
		return false;
	}
}
