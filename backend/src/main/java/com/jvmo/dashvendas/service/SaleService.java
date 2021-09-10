package com.jvmo.dashvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvmo.dashvendas.dto.SaleDTO;
import com.jvmo.dashvendas.dto.SaleSuccessDTO;
import com.jvmo.dashvendas.dto.SaleSumDTO;
import com.jvmo.dashvendas.entities.Sale;
import com.jvmo.dashvendas.repositories.SaleRepository;
import com.jvmo.dashvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	/*Busca paginada com atributo pageable*/
	@Transactional(readOnly = true) /*Serve para toda a operação ser na service*/
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}