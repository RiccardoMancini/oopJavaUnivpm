package it.univpm.JavaEsame.Controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.JavaEsame.Computing.Computing;
import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Data.ArrayMetadata;
import it.univpm.JavaEsame.Data.Parsing;
import it.univpm.JavaEsame.Model.HelloWorldClass;
import it.univpm.JavaEsame.Model.Metadata;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;

@RestController
public class simpleRestController {
	@GetMapping("/hello")
	public HelloWorldClass exampleMethod(@RequestParam(name="param1", defaultValue="Prova")  String param1) {
		return new HelloWorldClass("Riccardo","Mancini");
	}
	
	@GetMapping("/metadata")
	public ArrayList<Metadata> getMetadata() {
		return new ArrayMetadata().getArrayMetadata();
	}
	
	@GetMapping("/data")
	public ArrayList<ServiziPostali> getData() throws IOException {
	
		return ArrayData.getData();

	}
	
	@GetMapping("/operation/{anno}")
	public ArrayList<Operation> getOperation(@PathVariable("anno") String anno) {
			
		Computing op = new Computing(anno);
		return op.arrayOperation();
		}
	
}