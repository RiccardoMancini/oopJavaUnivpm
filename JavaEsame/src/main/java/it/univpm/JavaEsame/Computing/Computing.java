package it.univpm.JavaEsame.Computing;

import java.util.ArrayList;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;

public class Computing {
	
	private String Anno;
	private int cella;
	private ArrayList<Operation> arrayOp;
	
	public Computing (String Anno)
	{
		this.Anno=Anno;
		if (Anno.equals("2012"))cella = 0;
		if (Anno.equals("2013"))cella = 1;
		if (Anno.equals("2014"))cella = 2;
		if (Anno.equals("2015"))cella = 3;
		if (Anno.equals("2016"))cella = 4;
		if (Anno.equals("2017"))cella = 5;
	}
	
	
	public float Avg ()
	 {
		 float Somma=0;
		 int count=0;
		
		
			for  (int i=0; i < ArrayData.getData().size(); i++)
			{
				if (ArrayData.getData().get(i).getAnni()[cella] >= 0)
				{
					Somma += ArrayData.getData().get(i).getAnni()[cella];
					count ++;
				}
			}
			
			
			return Somma/count;
			
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
		float Somma = 0, count = 0, standardDeviation = 0;
      
        for(int i=0; i< ArrayData.getData().size(); i++) {
        	if (ArrayData.getData().get(i).getAnni()[cella] >= 0)
        	{
        		Somma += ArrayData.getData().get(i).getAnni()[cella];
        		count ++;
        	}
        }
        float mean = Somma/count;
        for(int i=0; i < count; i++) {
            standardDeviation += Math.pow(i - mean, 2);
        }
        return (float) Math.sqrt(standardDeviation/count);
	}
	
	public float Sum()
	{
		return 0;
	}
	
	public float Count()
	{
		return 0;
	}
	
	public ArrayList<Operation> arrayOperation()
	{
		arrayOp = new ArrayList<Operation>();
		arrayOp.add(new Operation(Avg(), Max(), Min()));

		return arrayOp;
	}
}
