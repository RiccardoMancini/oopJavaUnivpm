package it.univpm.JavaEsame.Filter;

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
	private Object[] value2;
	
	public FilterUtils()
	{
		out = new ArrayList<ServiziPostali>();
		out2 = new ArrayList<ServiziPostali>();
	}
	
	public static boolean check(Object value1, String operator, Object[] value2)
	{
		if (value2.length==1)	
		{
			if (value1 instanceof Number && value2[0] instanceof Number) 
			{	
				Double value1C = ((Number)value1).doubleValue();
				Double value2C = ((Number)value2[0]).doubleValue();
				
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
			
			else if(value2[0] instanceof String && value1 instanceof String)
			{
				switch (operator) {
				 
				case "in":
					return value1.equals(value2[0]);
					
				case "nin":
					return !value1.equals(value2[0]);
				}
			}
		
		}
		else if(value2.length==2)
		{
			if (value1 instanceof Number && value2[0] instanceof Number && value2[1] instanceof Number) 
			{	
				Double value1C = ((Number)value1).doubleValue();
				Double value2C = ((Number)value2[0]).doubleValue();
				Double value3C = ((Number)value2[1]).doubleValue();
				
				if (operator.equals("bt"))
				{
					return ((value1C > value2C) && (value1C < value3C));
				}
			}
			
		}
		return false;			
	 }
	
	public void selectNum(String attribute, String operator, String value) {
		
		String[] value1 = value.split(",");
		
			if(value1.length==1)
			{
				value2 = new Double[1];
				value2[0]=Double.parseDouble(value1[0]);
			}
			else
			{
				value2 = new Double[2];
				value2[0]=Double.parseDouble(value1[0]);
				value2[1]=Double.parseDouble(value1[1]);
			}
			
			if(!(out.isEmpty()))
			{
				for(int i=0; i<out.size(); i++)
				{
						if(FilterUtils.check(out.get(i).getAnni()[cella], operator, value2)) 
						{
							out2.add(out.get(i));
							
						}
				}
				out.clear();
				out.addAll(out2);
				out2.clear();
			}
			else {
				for(int i=0; i<ArrayData.getData().size(); i++) 
				{
				  if(ArrayData.getData().get(i).getAnni()[cella] >= 0)
				  {
					if(FilterUtils.check(ArrayData.getData().get(i).getAnni()[cella], operator, value2)) 
					{
						
						out.add(ArrayData.getData().get(i));
					}			
				  }
				}
			}
		
		
		
	}
	
	public void selectStr(String attribute, String operator, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String[] value1 = value.split(",");
		
		if(!(out.isEmpty()))
		{
		 for(int i=0; i<out.size(); i++)
		 {
			metodo = out.get(i).getClass().getMethod("get" + attribute.substring(0, 1).toUpperCase()+attribute.substring(1), null);
			tmp = metodo.invoke(out.get(i));	
				if(FilterUtils.check(tmp, operator, value1)) 
				{
					out2.add(out.get(i));
				}
			 }
		   out.clear();
		   out.addAll(out2);
		   out2.clear();
		}
	else {
		for(int i=0; i<ArrayData.getData().size(); i++) 
		{
			
			metodo = ArrayData.getData().get(i).getClass().getMethod("get" + attribute.substring(0, 1).toUpperCase()+attribute.substring(1), null);
			tmp = metodo.invoke(ArrayData.getData().get(i));
			
				if(FilterUtils.check(tmp, operator, value1)) 
				{
					out.add(ArrayData.getData().get(i));
				}
		 }
	   }
		
	}
	
	public ArrayList<ServiziPostali> select( String attribute, String operator, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	 {
		String[] value1 = value.split(",");
		attrControl aC = new attrControl(attribute);
		boolean c = aC.control();
		cella = aC.cellSet();
		
		if(c)
		{
			selectNum(attribute,operator,value);
		}
		else {
			
			selectStr(attribute,operator,value);
			
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

