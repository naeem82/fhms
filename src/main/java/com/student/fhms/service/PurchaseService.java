package com.student.fhms.service;

import java.util.List;

import com.student.fhms.entity.Purchase;

public interface PurchaseService {
	public List<Purchase> getPurchases();
	public Purchase getPurchase(int id);
	public void savePurchase(Purchase purchase);
	public void deletePurchase(int id);
	public List<Purchase> searchPurchase(String theSearchName);

}
