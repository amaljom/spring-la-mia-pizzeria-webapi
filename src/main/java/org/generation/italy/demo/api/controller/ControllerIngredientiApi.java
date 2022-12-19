package org.generation.italy.demo.api.controller;

import java.util.List;

import org.generation.italy.demo.pojo.Ingrediente;
import org.generation.italy.demo.pojo.Pizza;
import org.generation.italy.demo.service.IngredienteService;
import org.generation.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1/ingredienti")
@CrossOrigin("*")
public class ControllerIngredientiApi {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@Autowired
	private PizzaService pizzaSerive;
	
	@GetMapping("/all")
	public List<Ingrediente> getAll() {
		
		List<Ingrediente> ingredienti = ingredienteService.findAll();
		return ingredienti;
	}
	
	@GetMapping("/by/pizza/{id}")
	public List<Ingrediente> getIngredientiByPizzaId(
			@PathVariable("id") int id
	) {
		
		Pizza pizza = pizzaSerive.findPizzaById(id).get();
		
		return pizza.getIngrediente();
	}
}
