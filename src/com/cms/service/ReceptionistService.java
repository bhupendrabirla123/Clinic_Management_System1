package com.cms.service;

import java.util.ArrayList;
import java.util.List;

import com.cms.dao.ReceptinistDao;
import com.cms.dao.ReceptionistDaoImpl;
import com.cms.model.Receptionist_Details;

public class ReceptionistService {

	public static boolean insertDocCheck(Receptionist_Details rec) throws Exception{
		if (Patterncheck.checkid(rec.getId()) && Patterncheck.checkname(rec.getName())
				&& Patterncheck.checkusername(rec.getUsername())) {
			ReceptinistDao dao = new ReceptionistDaoImpl();
			int result = dao.insertReceptionist(rec);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean updatecheck(Receptionist_Details rec) throws Exception {
		if (Patterncheck.checkid(rec.getId()) && Patterncheck.checkname(rec.getName())
				&& Patterncheck.checkusername(rec.getUsername())) {
			ReceptinistDao dao = new ReceptionistDaoImpl();
			int result = dao.updateReceptionist(rec);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static boolean delete(int id) throws Exception {
		if (Patterncheck.checkid(id)) {
			ReceptinistDao dao = new ReceptionistDaoImpl();
			int result = dao.delete(id);
			if (result == 1) {
				return true;
			}
		}
		return false;
	}

	public static List<Receptionist_Details> view() throws Exception {
		ReceptinistDao rd = new ReceptionistDaoImpl();
		List<Receptionist_Details> list = new ArrayList<Receptionist_Details>();
		list.addAll(rd.view());
		return list;
	}

//	public static Receptionist_Details singleview(int id) {
//		if (Patterncheck.checkid(id)) {
//			ReceptinistDao dao = new ReceptionistDaoImpl();
//			Receptionist_Details rd = new Receptionist_Details();
//			rd = dao.(id);
//			return pd;
//		}
//		return null;
//	}

}
