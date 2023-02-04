package com.usecases;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("1. Admin Login");
		System.out.println("2. Customer Login");
		System.out.println("3. Customer Registration");
		System.out.println("4. Exit");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		
		if(input == 1) LoginAdmin.loginAdmin();
		else if(input==2) LoginCustomer.loginCustomer();
		else if(input==3) RegisterCustomer.registerCustomer();
		else if(input==4)System.out.println("Exited...");
		else Main.main(args);;
		
		sc.close();
	}

}
