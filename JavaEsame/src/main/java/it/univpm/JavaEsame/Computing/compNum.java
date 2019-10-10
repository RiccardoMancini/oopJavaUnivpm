package it.univpm.JavaEsame.Computing;

import java.util.ArrayList;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;
import it.univpm.JavaEsame.Model.annoControl;


public class compNum {
	
	private int cella;
	private ArrayList<Operation> arrayOp;
	private ArrayList<ServiziPostali> arrSP;
	private annoControl aC;
	
	public compNum (String Anno, ArrayList<ServiziPostali> arrSP)
	{
		
		aC = new annoControl(Anno);
		cella = aC.cellSet();
	    this.arrSP = new ArrayList<ServiziPostali>(arrSP);
	}
		
	 public float Avg()
	 {
			
		return Sum()/Count();
			
	 }
	
	public float Max()
	{
		float m = 0;
		for (int i=0; i < arrSP.size(); i++)
		{
			if (arrSP.get(i).getAnni()[cella] > m)
			{
				m=arrSP.get(i).getAnni()[cella];
			}
		}

		return m;
	}
	
	public float Min()
	{
		float m=0;
		
		for (int i=0; i < arrSP.size(); i++)
		{
			if (arrSP.get(i).getAnni()[cella] >= 0) 
			{
			   if (arrSP.get(i).getAnni()[cella] < m)
			   {
				   m=arrSP.get(i).getAnni()[cella];
			   }
			}
		}
		return m;
	}
	
	public float Dev_std()
	{
		float count = 0, standardDeviation = 0;
      
   
        for(int i=0; i < arrSP.size(); i++) {
        	if (arrSP.get(i).getAnni()[cella] >= 0)
        	{
        		standardDeviation += Math.pow(arrSP.get(i).getAnni()[cella] - Avg(), 2);
        		count++;
        	}
        }
        return (float) Math.sqrt(standardDeviation/count);
	}
	
	public float Sum()
	{
		float Somma = 0;
	      
        for(int i=0; i< arrSP.size(); i++) {
        	if (arrSP.get(i).getAnni()[cella] >= 0)
        	{
        		Somma += arrSP.get(i).getAnni()[cella];
        		
        	}
        }
        
		return Somma;
	}
	
	public int Count()
	{
		int count = 0;
	      
        for(int i=0; i< arrSP.size(); i++) {
        	if (arrSP.get(i).getAnni()[cella] >= 0)
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
