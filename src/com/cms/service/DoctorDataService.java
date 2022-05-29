package com.cms.service;

import java.util.List;

import com.cms.dao.DoctorDao;
import com.cms.dao.DoctorDaoImpl;
import com.cms.model.Doctor_Details;

public class DoctorDataService {

	public static boolean insertDocCheck(Doctor_Details doc) throws Exception {

		if (Patterncheck.checkid(doc.getId()) && Patterncheck.checkname(doc.getName())
				&& Patterncheck.checkcontact(doc.getContactNumber()) && Patterncheck.checkemail(doc.getEmailId())) {
			DoctorDao dao = new DoctorDaoImpl();
			int result = dao.insertDoctor(doc);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean updatecheck(Doctor_Details doc) throws Exception {
		if (Patterncheck.checkid(doc.getId()) && Patterncheck.checkname(doc.getName())
				&& Patterncheck.checkcontact(doc.getContactNumber()) && Patterncheck.checkemail(doc.getEmailId())) {
			DoctorDao dao = new DoctorDaoImpl();
			int result = dao.updateDoctor(doc);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean delete(int id) throws Exception {
		if (Patterncheck.checkid(id)) {
			DoctorDao dao = new DoctorDaoImpl();
			int result = dao.delete(id);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static Doctor_Details singleview(int id) throws Exception {
		if (Patterncheck.checkid(id)) {
			DoctorDao dao = new DoctorDaoImpl();
			Doctor_Details doc = new Doctor_Details();
			doc = dao.getdoc(id);
			return doc;
		}
		return null;
	}

	public static List<Doctor_Details> view() throws Exception {
		DoctorDao doc = new DoctorDaoImpl();
		List<Doctor_Details> list = doc.view();
		return list;
	}

}
