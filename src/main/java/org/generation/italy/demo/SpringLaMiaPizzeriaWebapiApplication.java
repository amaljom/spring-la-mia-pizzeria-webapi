package org.generation.italy.demo;

import org.generation.italy.demo.pojo.Penna;
import org.generation.italy.demo.service.PennaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaWebapiApplication  implements CommandLineRunner{
	
	@Autowired
	private PennaService pennaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaWebapiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Penna p1 = new Penna("rossa");
		Penna p2 = new Penna("blu");
		Penna p3 = new Penna("nera");
		
		pennaService.save(p1);
		pennaService.save(p2);
		pennaService.save(p3);
	}
	
}
