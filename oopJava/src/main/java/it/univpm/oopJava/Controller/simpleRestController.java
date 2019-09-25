package it.univpm.oopJava.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.oopJava.Model.HelloWorldClass;

public class simpleRestController {
	@GetMapping("/hello")
	public HelloWorldClass exampleMethod(@RequestParam(name="param1", defaultValue="Prova") String param1) {
		return new HelloWorldClass("Riccardo","Mancini");
	}

}
