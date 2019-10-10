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

import it.univpm.JavaEsame.Computing.compNum;
import it.univpm.JavaEsame.Computing.compString;
import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Data.ArrayMetadata;
import it.univpm.JavaEsame.Filter.FilterUtils;
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
	
	@RequestMapping(value = "/data", method = RequestMethod.GET, params = {"attribute1", "operator1", "value1", "logicOp", "attribute2", "operator2", "value2"})
	public ArrayList<ServiziPostali> getData(@RequestParam String attribute1, String operator1, String value1, String logicOp, String attribute2, String operator2, String value2) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		FilterUtils fu = new FilterUtils();
		if(logicOp.equals("and"))
		{
			fu.select(attribute1, operator1, value1);
			return fu.select(attribute2, operator2, value2);
		}
		else if (logicOp.equals("or"))
		{
			
			return fu.select_OR(attribute1, operator1, value1, attribute2, operator2, value2);
		}
		else return null;
		
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