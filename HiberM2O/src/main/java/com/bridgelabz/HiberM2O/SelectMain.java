package com.bridgelabz.HiberM2O;

import java.util.Scanner;

import com.bridglabz.dao.StudentDao;



public class SelectMain {

	public static void main(String[] args) {

		StudentDao studentDao=new StudentDao();
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
				
					studentDao.insert();
					break;
				case 2:
					studentDao.display();
					break;
				case 3:
					studentDao.update();
					break;
				case 4:
					studentDao.delete();
					break;
				default:
					System.out.println("enter correct choice ");
					break;

				}

				enter = scanner.next().charAt(0);

			} while (enter != 'n');
		}
			// TODO Auto-generated method stub
		// TODO Auto-generated method stub

	}


