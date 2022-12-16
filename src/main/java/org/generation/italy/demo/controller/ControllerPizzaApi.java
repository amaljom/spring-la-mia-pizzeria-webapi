package org.generation.italy.demo.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/pizza")
@CrossOrigin("*")
public class ControllerPizzaApi {
	
	@Autowired
	private PizzaService ps;
	
	@GetMapping("/all")
	public List<Pizza> getAll() {
		
		List<Pizza> pizze = ps.findAll();
		return pizze;
	}
}
