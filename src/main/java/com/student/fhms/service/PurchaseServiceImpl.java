package com.student.fhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.fhms.dao.PurchaseDAO;
import com.student.fhms.entity.Purchase;
@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	private PurchaseDAO purchaseDAO;

	@Override
	@Transactional
	public List<Purchase> getPurchases() {
		return purchaseDAO.getPurchases();
	}

	@Override
	@Transactional
	public Purchase getPurchase(int id) {
		
		return purchaseDAO.getPurchase(id);
	}

	@Override
	@Transactional
	public void savePurchase(Purchase purchase) {
		purchaseDAO.savePurchase(purchase);

	}

	@Override
	@Transactional
	public void deletePurchase(int id) {
		purchaseDAO.deletePurchase(id);

	}

	@Override
	@Transactional
	public List<Purchase> searchPurchase(String theSearchName) {
		return purchaseDAO.searchPurchase(theSearchName);
	}

	@Override
	@Transactional
	public List<Purchase> getPurchaseInformationCowsThatAreNotSold() {
		
		return purchaseDAO.getPurchaseInformationCowsThatAreNotSold();
	}

}
