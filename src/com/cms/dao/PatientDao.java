package com.cms.dao;

import java.util.List;

import com.cms.model.Patient_Details;

public interface PatientDao {
	public int insertPatient(Patient_Details patiDetails);

	public List<Patient_Details> view();

	public int updatePatient(Patient_Details p);

	public int delete(int id);

	public Patient_Details viewsingle(int id);

}
