package it.univpm.JavaEsame.Filter;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Model.ServiziPostali;
import it.univpm.JavaEsame.Model.annoControl;


public class FilterUtils 
{
	private static ArrayList<ServiziPostali> out,out2;
	private Object tmp,tmp1,tmp2;
	private Method metodo,metodo1,metodo2;
	private int cella,cella1,cella2;
	private Object[] value2, valueS1_1, valueS2_2;
	
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
	
	public void selectNum_OR(String attribute1, String operator1, String value1 ,String attribute2, String operator2, String value2) {
		
		String[] valueS1 = value1.split(",");
		String[] valueS2 = value2.split(",");
		
			if(valueS1.length==1)
			{
				valueS1_1 = new Double[1];
				valueS1_1[0]=Double.parseDouble(valueS1[0]);
			}
			else
			{
				valueS1_1 = new Double[2];
				valueS1_1[0]=Double.parseDouble(valueS1[0]);
				valueS1_1[1]=Double.parseDouble(valueS1[1]);
			}
			if(valueS2.length==1)
			{
				valueS2_2 = new Double[1];
				valueS2_2[0]=Double.parseDouble(valueS2[0]);
			}
			else
			{
				valueS2_2 = new Double[2];
				valueS2_2[0]=Double.parseDouble(valueS2[0]);
				valueS2_2[1]=Double.parseDouble(valueS2[1]);
			}
			
			for(int i=0; i<ArrayData.getData().size(); i++) 
			{
			 
			if(ArrayData.getData().get(i).getAnni()[cella1] >= 0 && ArrayData.getData().get(i).getAnni()[cella2] >= 0)
			  {
				if((FilterUtils.check(ArrayData.getData().get(i).getAnni()[cella1], operator1, valueS1_1) && ArrayData.getData().get(i).getAnni()[cella1] != -1)
				    || FilterUtils.check(ArrayData.getData().get(i).getAnni()[cella2], operator2, valueS2_2) && ArrayData.getData().get(i).getAnni()[cella2]!= -1) 
				{
					
					out.add(ArrayData.getData().get(i));
				}			
			  }
			}	
	}
	
	public void selectStr_OR(String attribute1, String operator1, String value1 ,String attribute2, String operator2, String value2) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String[] valueS1 = value1.split(",");
		String[] valueS2 = value2.split(",");
		
		
		for(int i=0; i<ArrayData.getData().size(); i++) 
		{
			metodo1 = ArrayData.getData().get(i).getClass().getMethod("get" + attribute1.substring(0, 1).toUpperCase()+attribute1.substring(1), null);
			tmp1 = metodo1.invoke(ArrayData.getData().get(i));
			metodo2 = ArrayData.getData().get(i).getClass().getMethod("get" + attribute2.substring(0, 1).toUpperCase()+attribute2.substring(1), null);
			tmp2 = metodo2.invoke(ArrayData.getData().get(i));
						
				if(FilterUtils.check(tmp1, operator1, valueS1) || FilterUtils.check(tmp2, operator2, valueS2)) 
				{
					out.add(ArrayData.getData().get(i));
				}
		 }
	   
	}
	
	public ArrayList<ServiziPostali> select( String attribute, String operator, String value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	 {
		//String[] value1 = value.split(",");
		annoControl aC = new annoControl(attribute);
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

	public ArrayList<ServiziPostali> select_OR( String attribute1, String operator1, String value1 ,String attribute2, String operator2, String value2) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException 
	{
		annoControl aC1 = new annoControl(attribute1);
		boolean c1 = aC1.control();
		cella1 = aC1.cellSet();
		annoControl aC2 = new annoControl(attribute2);
		boolean c2 = aC2.control();
		cella2 = aC2.cellSet();
		
		if(c1 && c2)
		{
			selectNum_OR(attribute1, operator1, value1 , attribute2, operator2, value2);
		}
		else if(!c1 && !c2)
		{
			selectStr_OR(attribute1, operator1, value1 , attribute2, operator2, value2);
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

