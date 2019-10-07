package it.univpm.JavaEsame.Computing;

import java.util.HashMap;
import it.univpm.JavaEsame.Data.ArrayData;

public class Stringhe {
	 // Creating a HashMap containing char 
    // as a key and occurrences as  a value 
    HashMap<String, Integer> stringCount;
  

   
    public  Stringhe()
    {
    	stringCount = new HashMap<String, Integer>(); 	
	    	
    }
    
    public void FreqOccorrence()
    {
    	 for (int i=0; i<ArrayData.getData().size(); i++)
     	{ 
         if (stringCount.containsKey( ArrayData.getData().get(i).getFreq() )) { 

             stringCount.put(ArrayData.getData().get(i).getFreq(), stringCount.get(ArrayData.getData().get(i).getFreq()) + 1); 
         } 
         else { 

              stringCount.put(ArrayData.getData().get(i).getFreq(), 1); 
         } 
        }
    }
    
    public void UnitOccorrence()
    {
    	 for (int i=0; i<ArrayData.getData().size(); i++)
	      	{ 
	          if (stringCount.containsKey( ArrayData.getData().get(i).getUnit() )) { 

	              stringCount.put(ArrayData.getData().get(i).getUnit(), stringCount.get(ArrayData.getData().get(i).getUnit()) + 1); 
	          } 
	          else { 

	               stringCount.put(ArrayData.getData().get(i).getUnit(), 1); 
	          } 
	         }    	
    }
    
    public void IndicpsOccorrence()
    {
    	 for (int i=0; i<ArrayData.getData().size(); i++)
	      	{ 
	          if (stringCount.containsKey( ArrayData.getData().get(i).getIndic_ps() )) { 

	              stringCount.put(ArrayData.getData().get(i).getIndic_ps(), stringCount.get(ArrayData.getData().get(i).getIndic_ps()) + 1); 
	          } 
	          else { 

	               stringCount.put(ArrayData.getData().get(i).getIndic_ps(), 1); 
	          } 
	         }    	
    }
    
    public void GeoOccorrence()
    {
    	 for (int i=0; i<ArrayData.getData().size(); i++)
	      	{ 
	          if (stringCount.containsKey( ArrayData.getData().get(i).getGeo() )) { 

	              stringCount.put(ArrayData.getData().get(i).getGeo(), stringCount.get(ArrayData.getData().get(i).getGeo()) + 1); 
	          } 
	          else { 

	               stringCount.put(ArrayData.getData().get(i).getGeo(), 1); 
	          } 
	         }    	
    }
  
    public HashMap <String, Integer> stringOccorrence(String attribute)
    {
    	if(attribute.equals("freq")) FreqOccorrence();
    	if(attribute.equals("unit")) UnitOccorrence();
    	if(attribute.equals("indicps")) IndicpsOccorrence();
    	if(attribute.equals("geo")) GeoOccorrence();
        	
    	return stringCount;
    }
    

 
}
