package org.generation.italy.demo.service;

import java.util.List;

import org.generation.italy.demo.pojo.Penna;
import org.generation.italy.demo.repo.PennaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PennaService{
	
	@Autowired
	private PennaRepo pennaRepo;
	
	public void save(Penna penna) {
		
		pennaRepo.save(penna);
	}
	public List<Penna> findAll() {
		
		return pennaRepo.findAll();
	}
	
	
}
