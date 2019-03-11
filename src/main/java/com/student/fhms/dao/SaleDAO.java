package com.student.fhms.dao;

import java.util.List;

import com.student.fhms.entity.Sale;

public interface SaleDAO {
	public List<Sale> getSales();
	public Sale getSale(int id);
	public void saveSale(Sale sale);
	public void deleteSale(int id);
	public List<Sale> searchSale(String theSearchName);

}
