package it.univpm.JavaEsame.Model;

public class annoControl {
	
	private String attribute;
	
	public annoControl(String attribute)
	{
		this.attribute = attribute;
	
	}
	
	public boolean control()
	{
		switch (attribute) {
		case "2012": return true;
		case "2013": return true;
		case "2014": return true;
		case "2015": return true;
		case "2016": return true;
		case "2017": return true;
		default: return false;
		}
		
	}
	
	public int cellSet()
	{
	
		switch (attribute) {
		case "2012": return 0;
		case "2013": return 1;
		case "2014": return 2;
		case "2015": return 3;
		case "2016": return 4;
		case "2017": return 5;
		default: return 6 ;
		}
		
		
		
		
		
	}
	
	

}
