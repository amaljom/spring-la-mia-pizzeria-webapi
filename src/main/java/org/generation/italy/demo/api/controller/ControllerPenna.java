package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Penna;
import org.generation.italy.demo.service.PennaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/penna")
@CrossOrigin("*")
public class ControllerPenna {

	@Autowired
	private PennaService pennaService;
	
	@GetMapping("/all")
	public List<Penna> getAll() {
		
		List<Penna> penne = pennaService.findAll();
		return penne;
	}
}

