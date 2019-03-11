package com.student.fhms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.fhms.dao.SaleDAO;
import com.student.fhms.entity.Sale;

@Service
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleDAO saleDAO;

	@Override
	@Transactional
	public List<Sale> getSales() {
	
		return saleDAO.getSales();
	}

	@Override
	@Transactional
	public Sale getSale(int id) {
		
		return saleDAO.getSale(id);
	}

	@Override
	@Transactional
	public void saveSale(Sale sale) {
		saleDAO.saveSale(sale);

	}

	@Override
	@Transactional
	public void deleteSale(int id) {
		saleDAO.deleteSale(id);

	}

	@Override
	@Transactional
	public List<Sale> searchSale(String theSearchName) {
		
		return saleDAO.searchSale(theSearchName);
	}

}
