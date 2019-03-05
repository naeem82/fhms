package com.student.fhms.dao;

import java.util.List;

import com.student.fhms.entity.Cow;

public interface CowDAO {
	public List<Cow> getCows();
	public Cow getCow(int id);
	public void saveCow(Cow cow);
	public void deleteCow();
	public List<Cow> searchCow(String theSearchName);

}
