package it.univpm.JavaEsame.Data;

import java.util.ArrayList;

public class ArrayData {

public static ArrayList<ServiziPostali> data;
	
	
	public ArrayData ()
	{
		data = new ArrayList<ServiziPostali>();
		
	}
	
	
	public static ArrayList<ServiziPostali> getData() {
		return data;
	}


	public String print()
	{
		
		return data.get(1009).getFreq() + " "+data.get(1009).getUnit() + " "+data.get(1009).getIndic_ps() + " "+
			   data.get(1009).getGeo() + " "+data.get(1009).getAnni()[4] + "\n";
	}

}
