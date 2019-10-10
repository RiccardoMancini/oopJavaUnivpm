package it.univpm.JavaEsame.Computing;

import java.util.ArrayList;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Model.Operation;


public class compNum {
	
	private int cella;
	private ArrayList<Operation> arrayOp;
	
	public compNum (String Anno)
	{
		
		try {
			switch (Anno) {
			case "2012": cella=0; break;
			case "2013": cella=1; break;
			case "2014": cella=2; break;
			case "2015": cella=3; break;
			case "2016": cella=4; break;
			case "2017": cella=5; break;
			}
		}
		catch(Exception e) { System.out.print("Anno non esistente!");}
		 
		
		}
		
	
	
	
	public float Avg()
	 {
			
			return Sum()/Count();
			
	 }
	
	public float Max()
	{
		float m = 0;
		for (int i=0; i < ArrayData.getData().size(); i++)
		{
			if (ArrayData.getData().get(i).getAnni()[cella] > m)
			{
				m=ArrayData.getData().get(i).getAnni()[cella];
			}
		}

		return m;
	}
	
	public float Min()
	{
		float m=0;
		
		for (int i=0; i < ArrayData.getData().size(); i++)
		{
			if (ArrayData.getData().get(i).getAnni()[cella] >= 0) 
			{
			   if (ArrayData.getData().get(i).getAnni()[cella] < m)
			   {
				   m=ArrayData.getData().get(i).getAnni()[cella];
			   }
			}
		}
		return m;
	}
	
	public float Dev_std()
	{
		float count = 0, standardDeviation = 0;
      
   
        for(int i=0; i < ArrayData.getData().size(); i++) {
        	if (ArrayData.getData().get(i).getAnni()[cella] >= 0)
        	{
        		standardDeviation += Math.pow(ArrayData.getData().get(i).getAnni()[cella] - Avg(), 2);
        		count++;
        	}
        }
        return (float) Math.sqrt(standardDeviation/count);
	}
	
	public float Sum()
	{
		float Somma = 0;
	      
        for(int i=0; i< ArrayData.getData().size(); i++) {
        	if (ArrayData.getData().get(i).getAnni()[cella] >= 0)
        	{
        		Somma += ArrayData.getData().get(i).getAnni()[cella];
        		
        	}
        }
        
		return Somma;
	}
	
	public int Count()
	{
		int count = 0;
	      
        for(int i=0; i< ArrayData.getData().size(); i++) {
        	if (ArrayData.getData().get(i).getAnni()[cella] >= 0)
        	{
        		
        		count ++;
        	}
        }
        return count;
	}
	
	public ArrayList<Operation> arrayOperation()
	{
		arrayOp = new ArrayList<Operation>();
        arrayOp.add(new Operation(Avg(), Max(), Min(), Dev_std(), Sum(), Count()));

		return arrayOp;
	}
}
