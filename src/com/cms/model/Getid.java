package com.cms.model;

import java.util.Random;

public class Getid {
	public static String getrandom() {
		Random rn = new Random();
		int number = rn.nextInt(999999);
		return String.format("%06d", number);
	}

}
