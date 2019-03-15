package com.student.fhms.dao;

import java.util.List;

import com.student.fhms.entity.Cow;

public interface CowDAO {
	public List<Cow> getCows();
	public Cow getCow(int id);
	public void saveCow(Cow cow);
	public void deleteCow(int id);
	public List<Cow> searchCow(String theSearchName);
	public List<Cow> getPurchasedCows();
	public List<Cow> getSaleableCows();
	public List<Cow> getPurchasedButNotSoldCows();

}
