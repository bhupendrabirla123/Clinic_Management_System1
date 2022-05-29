package com.cms.control;

import java.util.Scanner;

import com.cms.view.Admin;

public class Admincontrol {

	public void admin() {
		try (Scanner in = new Scanner(System.in);) {
			new Admin().admin();
			int n = in.nextInt();
			switch (n) {
			case 1:
				new CRUDDocCon().crudDoc();
				break;
			case 2:
				new CrudPatientcon().crudpatient();
				break;
			case 3:
				new CrudRecepControl().crudreception();
				break;
			case 4:
				new LoginCon().login();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Choose a valid Number");
				admin();
			}
		}catch(Exception e) {
			System.out.println("Characters not allowed");
			this.admin();
		}

	}

}
