package it.univpm.JavaEsame.Computing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import it.univpm.JavaEsame.Data.ArrayData;

public class compString {
	 // Creating a HashMap containing char 
    // as a key and occurrences as  a value 
    HashMap<String, Integer> stringCount;
    private String attribute;
    Method metodo;

   
    public  compString(String attribute) 
    {
    	stringCount = new HashMap<String, Integer>(); 	
	    this.attribute = attribute;
	   
    }
    
    public void Occorrence() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException

    {
    	 for (int i=0; i<ArrayData.getData().size(); i++)
     	{ 
    		metodo = ArrayData.getData().get(i).getClass().getMethod("get" + attribute.substring(0, 1).toUpperCase()+attribute.substring(1), null);

         if (stringCount.containsKey( metodo.invoke(ArrayData.getData().get(i)) )) { 

             stringCount.put((String) metodo.invoke(ArrayData.getData().get(i)), stringCount.get((String) metodo.invoke(ArrayData.getData().get(i))) + 1); 
        } 
         else { 

              stringCount.put((String) metodo.invoke(ArrayData.getData().get(i)), 1); 
         } 
        }
    }
    
  
  
    public HashMap <String, Integer> stringOccorrence() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
    	Occorrence();
        	
    	return stringCount;
    }
    

 
}
