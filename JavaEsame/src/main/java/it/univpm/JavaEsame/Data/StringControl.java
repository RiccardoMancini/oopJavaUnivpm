package it.univpm.JavaEsame.Data;

public class StringControl {
private String compare;
	
	public StringControl(String compare)
	{
		this.compare = compare;
	}

	public float control()
	{
	
		String[] row = compare.split("\\s+");
		
		if(row[0].equals(":"))
		{
			return -1;
		}
		else {
				return Float.parseFloat(row[0]);
		}
		
	}

}
