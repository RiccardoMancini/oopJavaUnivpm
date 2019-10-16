package it.univpm.JavaEsame.ManagingData;

import java.util.ArrayList;

import it.univpm.JavaEsame.Model.ServiziPostali;

/**
 * Classe contenente un ArrayList statico di ServiziPostali utilizzato per salvare i dati del dataset
 *
 */
public class ArrayData {								

public static ArrayList<ServiziPostali> data;
	
	
	public ArrayData ()									
	{
		data = new ArrayList<ServiziPostali>();
		
	}
	
	public static ArrayList<ServiziPostali> getData() {				
		return data;
	}

	public static void setData(ArrayList<ServiziPostali> data) {
		ArrayData.data = data;
	}


}
