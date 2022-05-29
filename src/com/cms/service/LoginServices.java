package com.cms.service;

import com.cms.dao.AdminDao;
import com.cms.dao.DoctorDao;
import com.cms.dao.DoctorDaoImpl;
import com.cms.dao.ReceptinistDao;
import com.cms.dao.ReceptionistDaoImpl;
import com.cms.model.Doctor_Details;

public class LoginServices {

	public static boolean adminlogin(String username, String password) {
		if (Patterncheck.checkusername(username) && Patterncheck.checkpassword(password)) {
			AdminDao dao = new AdminDao();
			String str = dao.get(username);
			if (str != null) {
				if (str.equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean doctorlogin(int id, String password) {
		if (Patterncheck.checkid(id) && Patterncheck.checkpassword(password)) {
			DoctorDao dao = new DoctorDaoImpl();
			Doctor_Details c = dao.getdoc(id);
			if (password.equals(c.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public static boolean receptionist(String username, String pass) {
		if (Patterncheck.checkusername(username) && Patterncheck.checkpassword(pass)) {
			ReceptinistDao dao = new ReceptionistDaoImpl();
			String password = dao.getpass(username);
			if (pass.equals(password)) {
				return true;
			}
		}

		return false;
	}

}
