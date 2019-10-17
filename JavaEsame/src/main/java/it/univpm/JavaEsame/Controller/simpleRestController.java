package it.univpm.JavaEsame.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.JavaEsame.Computing.CompNum;
import it.univpm.JavaEsame.Computing.CompString;
import it.univpm.JavaEsame.Exception.ExceptionsExtend;
import it.univpm.JavaEsame.Filter.FilterUtils;
import it.univpm.JavaEsame.ManagingData.ArrayData;
import it.univpm.JavaEsame.ManagingData.ArrayMetadata;
import it.univpm.JavaEsame.Model.Metadata;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;

@RestController
public class simpleRestController {
	
	/**
	 * Metodo che restituisce la lista dei metadata
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ArrayList<Metadata> getMetadata() {
		return new ArrayMetadata().getArrayMetadata();
	}
	
	/**
	 * Metodo che restituisce la lista dei dati
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ArrayList<ServiziPostali> getData()
	{
		return ArrayData.getData();
	}
	
	/**
	 * Metodo che restituisce la lista dei dati filtrati
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET, params = {"attribute", "operator", "value"})
	public ArrayList<ServiziPostali> getData(@RequestParam String attribute, String operator, String value) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
		return new FilterUtils().select(attribute, operator, value);
	}
	
	/**
	 * Metodo che restituisce la lista dei dati filtrati applicandoci gli operatori logici AND e OR
	 */
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
	
	/**
	 * Metodo che restituisce la lista delle statistiche sull' anno scelto
	 */
	@RequestMapping(value = "/operation", method = RequestMethod.GET)
	public ArrayList<Operation> getOperation(@RequestParam String anno) {
			
		CompNum op = new CompNum(anno, ArrayData.getData());
		return op.arrayOperation();
		}
	
	/**
	 * Metodo che restituisce la lista delle statistiche filtrate sull' anno scelto
	 */
	@RequestMapping(value = "/operation", method = RequestMethod.GET, params = {"anno", "attribute", "operator", "value"})
	public ArrayList<Operation> getOperation(@RequestParam String anno, String attribute, String operator, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			
		CompNum op = new CompNum(anno, new FilterUtils().select(attribute, operator, value));
		return op.arrayOperation();
		}
	
	/**
	 * Metodo che restituisce il numero delle occorrenze dell'attributo richiesto
	 */
	@RequestMapping(value = "/occorrence", method = RequestMethod.GET)
	public HashMap<String, Integer> getOccorrence(@RequestParam String attribute) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
			return new CompString(attribute).Occorrence();
		}


	
	/**
	 * Richiamo eccezione riguardante l'errata scrittura di un value
	 */
	@ExceptionHandler(NoSuchMethodException.class)
    public String handleMyException(Exception  exception) {
	return new ExceptionsExtend().valErr();
            }  
	
	/**
	 * Richiamo eccezione riguardante l'errata scrittura di una key
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMyException2(Exception  exception) {
     return new ExceptionsExtend().keyErr();
            }  
	
	/**
	 * Richiamo eccezione riguardante un anno scritto non valido
	 */
	@ExceptionHandler(NullPointerException.class)
    public String handleMyException3(Exception  exception) {
     return new ExceptionsExtend().annoErr();
            }  
	
}