package it.univpm.JavaEsame.ManagingData;

import it.univpm.JavaEsame.Exception.ExceptionsExtend;

public class AnnoControl {                   //Classe contenente metodi utili per la gestione dell'anno inserito
	
	private String anno;
	
	public AnnoControl(String anno)
	{
		this.anno = anno;
	
	}
	
	public boolean control()			//metodo che restituisce true se l'anno inserito esiste nel Metadata
	{
		switch (anno) {
		case "2012": return true;
		case "2013": return true;
		case "2014": return true;
		case "2015": return true;
		case "2016": return true;
		case "2017": return true;
		default: return false;
		}
		
	}
	
	public int cellSet()  throws ExceptionsExtend				//metodo che restituisce un numero da 0 a 5 in corrispondenza di ogni anno
	{
	
		
			switch (anno) {
			case "2012": return 0;
			case "2013": return 1;
			case "2014": return 2;
			case "2015": return 3;
			case "2016": return 4;
			case "2017": return 5;
			default: throw new ExceptionsExtend(anno);
			}
		
		
		
		
		
	}
	
	

}
