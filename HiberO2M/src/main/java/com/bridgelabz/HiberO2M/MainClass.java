package com.bridgelabz.HiberO2M;

import java.util.Scanner;

import com.bridgelabz.dao.DoctorDao;



public class MainClass {
	public static void main(String[] args){


		DoctorDao doctorDao=new DoctorDao();
			Scanner scanner = new Scanner(System.in);
			int choice=0;
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
				
					doctorDao.insert();
					break;
				case 2:
					doctorDao.display();
					break;
				case 3:
					doctorDao.update();
					break;
				case 4:
					doctorDao.delete();
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
