package com.cms.dao;

import java.util.List;

import com.cms.model.Doctor_Details;

public interface DoctorDao {

	public int insertDoctor(Doctor_Details doctoDetails);

	public List<Doctor_Details> view();

	public int updateDoctor(Doctor_Details doc);

	public int delete(int id);

	public Doctor_Details getdoc(int id);

}
