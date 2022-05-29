package com.cms.view;

import java.util.Scanner;

public class Admin {
	Scanner in = new Scanner(System.in);

	public void admin() {
		System.out.println("***************");
		System.out.println("1. CRUD Doctor");
		System.out.println("2. CRUD Patient");
		System.out.println("3. CRUD Receptionist");
		System.out.println("4. Back");
		System.out.println("5. Exit");
		System.out.println("***************");
		System.out.println("Choose a number");
	}

	public void Doctormenu() {
		System.out.println("***************");
		System.out.println("1. Add Doctor");
		System.out.println("2. View list of Doctors");
		System.out.println("3. Update Doctors list");
		System.out.println("4. Delete Doctor");
		System.out.println("5. view doctor info ");
		System.out.println("6. Back");
		System.out.println("7. Exit");
		System.out.println("***************");
		System.out.println("Choose a number");
	}

	public void patientmenu() {
		System.out.println("***************");
		System.out.println("1. Add patient");
		System.out.println("2. View patients");
		System.out.println("3. Update patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Back");
		System.out.println("6. Exit");
		System.out.println("***************");
		System.out.println("Choose a number");
	}

	public void crudreceptionistmenu() {
		System.out.println("***************");
		System.out.println("1. Add Receptionist");
		System.out.println("2. View Receptionist");
		System.out.println("3. Change Password");
		System.out.println("4. Delete Receptionist");
		System.out.println("5. Back");
		System.out.println("6. Exit");
		System.out.println("***************");
		System.out.println("Choose an operation");

	}

}
