package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import com.cms.dao.PatientDao;
import com.cms.dao.PatientDaoImpl;
import com.cms.model.Patient_Details;

public class PatientDataservices {

	public static boolean insertCheck(Patient_Details patient) throws Exception {

		if (Patterncheck.checkid(patient.getId()) && Patterncheck.checkname(patient.getName())
				&& Patterncheck.checkcontact(patient.getContactNumber())) {
			PatientDao dao = new PatientDaoImpl();
			int result = dao.insertPatient(patient);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean updatecheck(Patient_Details patient) throws Exception {
		if (Patterncheck.checkid(patient.getId()) && Patterncheck.checkname(patient.getName())
				&& Patterncheck.checkcontact(patient.getContactNumber())) {
			PatientDao dao = new PatientDaoImpl();
			int result = dao.updatePatient(patient);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean delete(int id) throws Exception {
		if (Patterncheck.checkid(id)) {
			PatientDao dao = new PatientDaoImpl();
			int result = dao.delete(id);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static Patient_Details singleview(int id) throws Exception {
		if (Patterncheck.checkid(id)) {
			PatientDao dao = new PatientDaoImpl();
			Patient_Details pd = new Patient_Details();
			pd = dao.viewsingle(id);
			return pd;
		}
		return null;
	}
	public static List<Patient_Details> view() throws Exception{
		List<Patient_Details> list = new ArrayList<Patient_Details>();
		PatientDao pd = new PatientDaoImpl();
		list.addAll(pd.view());
		return null;
	}

}
