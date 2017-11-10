package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.util.EmployeeDao;


public class MainSelect {

	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDao();
		Scanner scanner = new Scanner(System.in);
		int choice;
		char enter;
		do {
			System.out.println("enter choice");
			System.out.println("1.insert");
			System.out.println("2.display");
			System.out.println("3.update");
			System.out.println("4.delete");

			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				employeeDao.getObject();
				employeeDao.insert();
				break;
			case 2:
				employeeDao.display();
				break;
			case 3:
				employeeDao.update();
				break;
			case 4:
				employeeDao.delete();
				break;
			default:
				System.out.println("enter correct choice ");
				break;

			}

			enter = scanner.next().charAt(0);

		} while (enter != 'n');
	}
		// TODO Auto-generated method stub

	

}
