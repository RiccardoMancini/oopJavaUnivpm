package it.univpm.JavaEsame.ManagingData;

/**
 * Classe di controllo delle stringhe passate
 *
 */
public class StringControl {						
private String compare;
	
	public StringControl(String compare)
	{
		this.compare = compare;
	}

	/**
	 * Metodo che restituisce il valore -1 se la stringa compare contiene ":", 
	 * altrimenti restituisce il parseFloat della porzione di stringa contenente un numero 
	 */
	public double control()		
	{
	
		String[] row = compare.split("\\s+");
		
		if(row[0].equals(":"))
		{
			return -1;
		}
		else {
				return Double.parseDouble(row[0]);
		}
		
	}

}
