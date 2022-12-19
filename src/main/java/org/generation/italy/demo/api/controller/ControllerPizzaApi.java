package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/1/pizza")
@CrossOrigin("*")
public class ControllerPizzaApi {
	
	@Autowired
	private PizzaService ps;
	// Get all
	@GetMapping("/all")
	public List<Pizza> getAll() {
		
		List<Pizza> pizze = ps.findAll();
		return pizze;
	}
	// Delete
	@GetMapping("/delete/{id}")
	public boolean deletePizza(
			@PathVariable("id") int id
	) {
		
		try {
			
			Pizza pizza = ps.findPizzaById(id).get();
			ps.delete(pizza);
		} catch(Exception e) { return false; }
		
		return true;
	}
	// Create
	@PostMapping("/create")
	public Pizza createPizza(
			@Valid @RequestBody Pizza pizza
	) {
		
		System.err.println(pizza);
		
		Pizza newPizza = ps.save(pizza);
		
		System.err.println(newPizza);
		
		return newPizza;
	}
	
	// update
	@PostMapping("/update/{id}")
	public Pizza updatePizza(
			@PathVariable("id") int id, 
			@Valid @RequestBody Pizza pizza
	) {
	
		
		Pizza newPizza = ps.save(pizza);
		
		return newPizza;
	}
}
