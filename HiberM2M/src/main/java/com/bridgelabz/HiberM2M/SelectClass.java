package com.bridgelabz.HiberM2M;

import java.util.Scanner;

import com.bridgelabz.dao.DoctorDao;



public class SelectClass {
	public static void main(String[] args){


		DoctorDao doctorDao=new DoctorDao();
			Scanner scanner = new Scanner(System.in);
			int choice=0;
			char enter;
			do {
				System.out.println("enter choice");
				System.out.println("1.insertdoctor");
				System.out.println("2.insertpatient");
				System.out.println("3.display");
				System.out.println("4.update");
				System.out.println("5.delete");

				choice = scanner.nextInt();
				switch (choice) {
				case 1:
				
					doctorDao.insertDoctor();
					break;
				case 2:
					doctorDao.insertPatient();
					break;
				case 3:
					
					doctorDao.display();
					break;
				case 4:
					doctorDao.update();
					break;
				case 5:
					doctorDao.delete();
					break;
				default:
					System.out.println("enter correct choice ");
					break;

				}

				enter = scanner.next().charAt(0);

			} while (enter != 'n');
		}
			
}
