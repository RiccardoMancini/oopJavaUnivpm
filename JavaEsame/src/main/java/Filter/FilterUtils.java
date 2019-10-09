package Filter;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Model.ServiziPostali;


public class FilterUtils 
{
	private static ArrayList<ServiziPostali> out,out2;
	private Object tmp;
	private Method metodo;
	private int cella;
	
	public FilterUtils()
	{
		out = new ArrayList<ServiziPostali>();
		out2 = new ArrayList<ServiziPostali>();
	}
	
	public static boolean check(Object value1, String operator, Object value2)
	{
			
		if (value1 instanceof Number && value2 instanceof Number) 
		{	
			Double value1C = ((Number)value1).doubleValue();
			Double value2C = ((Number)value2).doubleValue();
			
			switch (operator) {
			 
			case "in":
				return value1C.equals(value2C);
				
			case "nin":
				return !value1C.equals(value2C);	
			
			case "gt":// >
				return value1C > value2C;
				
			case "gte":// >=
				return value1C >= value2C;
				
			case "lt":// <
				return value1C < value2C;
				
			case "lte":// <=
				return value1C <= value2C;
			}
		
			
		}
		else if(value2 instanceof String && value1 instanceof String)
		{
			switch (operator) {
			 
			case "in":
				return value1.equals(value2);
				
			case "nin":
				return !value1.equals(value2);
			}
		}
			
		return false;			
	 }
	

	
	public ArrayList<ServiziPostali> select( String attribute, String operator, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	 {


		if(attribute.equals("2012") || attribute.equals("2013") || attribute.equals("2014") ||
			attribute.equals("2015") || attribute.equals("2016") || attribute.equals("2017"))
		{
			if (attribute.equals("2012"))cella = 0;
			if (attribute.equals("2013"))cella = 1;
			if (attribute.equals("2014"))cella = 2;
			if (attribute.equals("2015"))cella = 3;
			if (attribute.equals("2016"))cella = 4;
			if (attribute.equals("2017"))cella = 5;
			
			if(!(out.isEmpty()))
			{
				for(int i=0; i<out.size(); i++)
				{
						if(FilterUtils.check(out.get(i).getAnni()[cella], operator, Float.parseFloat(value))) 
						{
							out2.add(out.get(i));
							
						}
				}
				out.clear();
				out.equals(out2);
				out2.clear();
			}
			else {
				for(int i=0; i<ArrayData.getData().size(); i++) 
				{
				  if(ArrayData.getData().get(i).getAnni()[cella] >= 0)
				  {
					if(FilterUtils.check(ArrayData.getData().get(i).getAnni()[cella], operator, Float.parseFloat(value))) 
					{
						
						out.add(ArrayData.getData().get(i));
					}			
				  }
				}
			}
		}
		else {
			if(!(out.isEmpty()))
			{
			 for(int i=0; i<out.size(); i++)
			 {
				metodo = out.get(i).getClass().getMethod("get" + attribute.substring(0, 1).toUpperCase()+attribute.substring(1), null);
				Object tmp = metodo.invoke(out.get(i));	
					if(FilterUtils.check(tmp, operator, value)) 
					{
						out2.add(out.get(i));
					}
				 }
			   out.clear();
			   out.equals(out2);
			   out2.clear();
			}
		else {
			for(int i=0; i<ArrayData.getData().size(); i++) 
			{
				
				metodo = ArrayData.getData().get(i).getClass().getMethod("get" + attribute.substring(0, 1).toUpperCase()+attribute.substring(1), null);
				tmp = metodo.invoke(ArrayData.getData().get(i));
				
					if(FilterUtils.check(tmp, operator, value)) 
					{
						out.add(ArrayData.getData().get(i));
					}
			 }
		   }
		}
		return out;
	}
	
	
	
	public static ArrayList<ServiziPostali> getOut() {
		return out;
	}

	public static void setOut(ArrayList<ServiziPostali> out) {
		FilterUtils.out = out;
	}
}

