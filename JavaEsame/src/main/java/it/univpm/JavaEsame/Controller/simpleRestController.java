package it.univpm.JavaEsame.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Filter.FilterUtils;
import it.univpm.JavaEsame.Computing.compNum;
import it.univpm.JavaEsame.Computing.compString;
import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Data.ArrayMetadata;
import it.univpm.JavaEsame.Model.HelloWorldClass;
import it.univpm.JavaEsame.Model.Metadata;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;

@RestController
public class simpleRestController {
	
	@GetMapping("/metadata")
	public ArrayList<Metadata> getMetadata() {
		return new ArrayMetadata().getArrayMetadata();
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ArrayList<ServiziPostali> getData()
	{
		return ArrayData.getData();
	}
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, params = {"attribute", "operator", "value"})
	public ArrayList<ServiziPostali> getData(@RequestParam String attribute, String operator, String value) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		return new FilterUtils().select(attribute, operator, value);
	}
	
	
	@GetMapping("/operation")
	public ArrayList<Operation> getOperation(@RequestParam String anno) {
			
		compNum op = new compNum(anno);
		return op.arrayOperation();
		}
	
	@GetMapping("/occorrence")
	public HashMap<String, Integer> getOccorrence(@RequestParam String attribute) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		;
		return new compString(attribute).stringOccorrence();
		}
	
}