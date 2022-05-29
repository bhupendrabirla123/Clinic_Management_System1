package com.cms.dao;

import java.util.List;

import com.cms.model.Receptionist_Details;

public interface ReceptinistDao {

	public int insertReceptionist(Receptionist_Details receptionist_Details);

	public List<Receptionist_Details> view();

	public int updateReceptionist(Receptionist_Details re);

	public int delete(int id);

	public String getpass(String username);

}
