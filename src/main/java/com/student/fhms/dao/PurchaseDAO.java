package com.student.fhms.dao;

import java.util.List;


import com.student.fhms.entity.Purchase;

public interface PurchaseDAO {
	public List<Purchase> getPurchases();
	public Purchase getPurchase(int id);
	public void savePurchase(Purchase purchase);
	public void deletePurchase(int id);
	public List<Purchase> searchPurchase(String theSearchName);
	public List<Purchase> getPurchaseInformationCowsThatAreNotSold();

}
