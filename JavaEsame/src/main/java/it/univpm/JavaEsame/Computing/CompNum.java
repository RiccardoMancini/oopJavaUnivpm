package it.univpm.JavaEsame.Computing;

import java.util.ArrayList;
import it.univpm.JavaEsame.Exception.ExceptionsExtend;
import it.univpm.JavaEsame.ManagingData.AnnoControl;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;


public class CompNum {                             //Classe  utilizzata per effettuare la computazione sull'attributo "anno" 
	
	private int cella;
	private ArrayList<Operation> arrayOp;
	private ArrayList<ServiziPostali> arrSP;
	private AnnoControl aC;
	
	public CompNum (String Anno, ArrayList<ServiziPostali> arrSP)   //Costruttore a cui viene passato l'anno scelto per effettuare la computazione, e l'ArrayList contenente i dati con cui vogliamo lavorare
	{
		try {
		aC = new AnnoControl(Anno);
		cella = aC.cellSet();
	    this.arrSP = new ArrayList<ServiziPostali>(arrSP);
		}catch(ExceptionsExtend e) {System.out.println(e.annoExc());}
	}
	
	 public double Avg()                            //Metodo utilizzato per il calcolo della media
	 {
			
		return Sum()/Count();
			
	 }
	
	public double Max()                            //Metodo utilizzato per il calcolo del massimo
	{
		double m = 0;
		for (int i=0; i < arrSP.size(); i++)
		{
			if (arrSP.get(i).getAnni()[cella] > m)
			{
				m=arrSP.get(i).getAnni()[cella];
			}
		}

		return m;
	}
	
	public double Min()                           //Metodo utilizzato per il calcolo del minimo
	{
		double m=0;
		
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
	
	public double Dev_std()                      //Metodo utilizzato per il calcolo della deviazione standard
	{
		double count = 0, standardDeviation = 0;
      
   
        for(int i=0; i < arrSP.size(); i++) {
        	if (arrSP.get(i).getAnni()[cella] >= 0)
        	{
        		standardDeviation += Math.pow(arrSP.get(i).getAnni()[cella] - Avg(), 2);
        		count++;
        	}
        }
        return (double) Math.sqrt(standardDeviation/count);
	}
	
	public double Sum()                         //Metodo utilizzato per il calcolo della somma 
	{
		double Somma = 0;
	      
        for(int i=0; i< arrSP.size(); i++) {
        	if (arrSP.get(i).getAnni()[cella] >= 0)
        	{
        		Somma += arrSP.get(i).getAnni()[cella];
        		
        	}
        }
        
		return Somma;
	}
	
	public int Count()                           //Metodo utilizzato per il conteggio di elementi
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
	
	public ArrayList<Operation> arrayOperation()  //Metodo che restituisce un Arraylist di tipo Operation
	{
		arrayOp = new ArrayList<Operation>();
        arrayOp.add(new Operation(Avg(), Max(), Min(), Dev_std(), Sum(), Count()));

		return arrayOp;
	}
}
