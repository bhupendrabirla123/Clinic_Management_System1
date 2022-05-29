package com.cms.control;

import java.util.Scanner;

import com.cms.service.LoginServices;
import com.cms.view.Login;

public class LoginCon {

	public void login() {
		try (Scanner in = new Scanner(System.in);) {
			new Login().loginmenu();

			int n = in.nextInt();
			switch (n) {
			case 1:
				this.adminlogin();
				break;
			case 2:
				this.doclogin();
				break;
			case 3:
				this.reclogin();
				break;
			default:
				System.out.println("Please choose a correct number");
				login();
				break;
			}
		} catch (Exception e) {
			System.out.println("Characters not allowed");
			this.login();
		}

	}

	public void adminlogin() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter your username");
			String username = in.next();
			System.out.println("Enter your password");
			String password = in.next();
			if (LoginServices.adminlogin(username, password)) {
				new Admincontrol().admin();
			} else {
				System.out.println("Wrong username or password");
				System.out.println();
				this.login();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.adminlogin();
		}
	}

	public void doclogin() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter your id");
			int id = in.nextInt();
			System.out.println("Enter your password");
			String password = in.next();
			if (LoginServices.doctorlogin(id, password)) {
				new Doccontrol().doctor();
			} else {
				System.out.println("Wrong username or password");
				System.out.println();
				this.login();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.adminlogin();
		}
	}

	public void reclogin() {
		try (Scanner in = new Scanner(System.in);) {
			System.out.println("Enter your username");
			String username = in.next();
			System.out.println("Enter your password");
			String password = in.next();
			if (LoginServices.receptionist(username, password)) {
				new Receptionistcont().receptionist();
			} else {
				System.out.println("Wrong username or password");
				System.out.println();
				this.login();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
			this.adminlogin();
		}
	}

}
