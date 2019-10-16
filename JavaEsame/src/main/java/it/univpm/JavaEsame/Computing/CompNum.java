package it.univpm.JavaEsame.Computing;

import java.util.ArrayList;
import it.univpm.JavaEsame.Exception.ExceptionsExtend;
import it.univpm.JavaEsame.ManagingData.AnnoControl;
import it.univpm.JavaEsame.Model.Operation;
import it.univpm.JavaEsame.Model.ServiziPostali;


/**
 * Classe  utilizzata per effettuare la computazione sull'attributo "anno" 
 *
 */
public class CompNum {                            
	
	private int cella;
	private ArrayList<Operation> arrayOp;
	private ArrayList<ServiziPostali> arrSP;
	private AnnoControl aC;
	
	/**
	 * Costruttore a cui viene passato l'anno scelto per effettuare la computazione, 
	 * e l'ArrayList contenente i dati con cui vogliamo lavorare
	 */
	public CompNum (String Anno, ArrayList<ServiziPostali> arrSP)   //
	{
		try {
		aC = new AnnoControl(Anno);
		cella = aC.cellSet();
	    this.arrSP = new ArrayList<ServiziPostali>(arrSP);
		}catch(ExceptionsExtend e) {System.out.println(e.annoExc());}
	}
	
	 /**
	 * Metodo utilizzato per il calcolo della media
	 */
	public double Avg()                        
	 {
			
		return Sum()/Count();
			
	 }
	
	/**
	 * Metodo utilizzato per il calcolo del massimo
	 */
	public double Max()                           
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
	
	/**
	 * Metodo utilizzato per il calcolo del minimo
	 */
	public double Min()                           
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
	
	/**
	 * Metodo utilizzato per il calcolo della deviazione standard
	 */
	public double Dev_std()                     
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
	
	/**
	 * Metodo utilizzato per il calcolo della somma 
	 */
	public double Sum()                       
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
	
	/**
	 * Metodo utilizzato per il conteggio di elementi
	 */
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
	
	/**
	 * Metodo che restituisce un Arraylist di tipo Operation
	 */
	public ArrayList<Operation> arrayOperation()  
	{
		arrayOp = new ArrayList<Operation>();
        arrayOp.add(new Operation(Avg(), Max(), Min(), Dev_std(), Sum(), Count()));

		return arrayOp;
	}
}
