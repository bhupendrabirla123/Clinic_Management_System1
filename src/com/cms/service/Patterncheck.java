package com.cms.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterncheck {
	public static boolean checkcontact(long contactno) {
		String str = "" + contactno;
		String syntx = "^[0-9]{10}$";
		Pattern p = Pattern.compile(syntx);
		Matcher m = p.matcher(str);
//		System.out.println(m.matches());
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkname(String name) {
//		String name = "Bhupendra Birla";
		String syntx = "^(?=[A-Z])[A-Za-z\\s]+$";
		Pattern p = Pattern.compile(syntx);
		Matcher m = p.matcher(name);
		// System.out.println(m.matches());
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkemail(String email) {
//		String email = "BhupendraBirla91@gmail.com";
		String syntx = "^(?![0-9_.])[A-Za-z%#$.*0-9]+@[a-zA-Z0-9.]+$";
		Pattern p = Pattern.compile(syntx);
		Matcher m = p.matcher(email);
//		System.out.println(m.matches());
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkid(int id1) {
		String id = "" + id1;
		String synt = "^[0-9]{6}$";
		Pattern p = Pattern.compile(synt);
		Matcher m = p.matcher(id);
//		System.out.println(m.matches());
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public static boolean checkusername(String username) {
//		String synt = "^(?![0-9@]$)[A-Za-z0-9]+@[0-9A-Za-z]$";
		String synt = "^[A-Z][A-Za-z0-9]+@[A-Za-z0-9]+$";
		Pattern p = Pattern.compile(synt);
		Matcher m = p.matcher(username);
//		System.out.println(m.matches());
		if (m.matches()) {
			return true;
		}

		return false;
	}

	public static boolean checkpassword(String password) {
		String synt = "^(?=.{8,16}$)(?=.*[A-Z])(?=.*[a-z])[A-Za-z0-9]+@[A-Za-z0-9]+$";
		Pattern p = Pattern.compile(synt);
		Matcher m = p.matcher(password);
//		System.out.println(m.matches());
		if (m.matches()) {
			return true;
		}
		return false;
	}

//	public static void main(String[] args) {
//		boolean b = checkpassword("Bhup@123");
//		System.out.println(b);
//	}

}
