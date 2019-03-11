package com.student.fhms.service;

import java.util.List;

import com.student.fhms.entity.Sale;

public interface SaleService {
	public List<Sale> getSales();
	public Sale getSale(int id);
	public void saveSale(Sale sale);
	public void deleteSale(int id);
	public List<Sale> searchSale(String theSearchName);

}
