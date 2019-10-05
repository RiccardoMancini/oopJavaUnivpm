package it.univpm.JavaEsame.Computing;

import java.util.ArrayList;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;

public class Computing {
	
	private String Anno;
	private int cella=0;
	private float avg, max, min;
	
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
		 this.avg = 0;
		 int count=0;
		
		
			for  (int i=0; i < ArrayData.getData().size(); i++)
			{
				if (ArrayData.getData().get(i).getAnni()[cella] >= 0)
				{
					Somma += ArrayData.getData().get(i).getAnni()[cella];
					count ++;
				}
			}
			avg = Somma/count;
			return  avg;
	 }
	
	public float Max()
	{
		this.max=0;
		
		for (int i=0; i < ArrayData.getData().size(); i++)
		{
			if (ArrayData.getData().get(i).getAnni()[cella] > max)
			{
				max=ArrayData.getData().get(i).getAnni()[cella];
			}
		}

		return max;
	}
	
	public float Min()
	{
		this.min=0;
		
		for (int i=0; i < ArrayData.getData().size(); i++)
		{
			if (ArrayData.getData().get(i).getAnni()[cella] >= 0) 
			{
			   if (ArrayData.getData().get(i).getAnni()[cella] < min)
			   {
				   min=ArrayData.getData().get(i).getAnni()[cella];
			   }
			}
		}
		return min;
	}
	
	public ArrayList<Operation> arrayOperation()
	{
		ArrayList<Operation> arrayOp = new ArrayList<Operation>();
		arrayOp.add(new Operation(Avg(), Max(), Min()));

		return arrayOp;
	}
}
