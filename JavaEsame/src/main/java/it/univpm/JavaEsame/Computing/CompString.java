package it.univpm.JavaEsame.Computing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import it.univpm.JavaEsame.ManagingData.ArrayData;

/**
 * Classe  utilizzata per effettuare il conteggio 
 * degli elementi unici indicando il numero delle occorrenze 
 */
public class CompString {									
 
    HashMap<String, Integer> stringCount;			
    private String attribute;						
    Method metodo;									

   
    /**
     * Costruttore a cui viene passato l'attributo del quale si vuole conteggiare le occorrenze,
     * e inizializzazione della tabella HashMap con key di tipo stringa e value di tipo integer
     * 
     */
    public  CompString(String attribute)								
    {
    	stringCount = new HashMap<String, Integer>(); 		
	    this.attribute = attribute;
	   
    }
    
 
    /**
     * Metodo che restituisce l' HashMap con i record dell'attributo scelto, indicandone la loro ricorrenza
     */
    public HashMap <String, Integer> Occorrence() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException

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
		return stringCount;
    }
    
}
