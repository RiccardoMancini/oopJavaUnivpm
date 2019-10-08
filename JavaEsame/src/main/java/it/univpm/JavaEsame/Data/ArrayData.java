package it.univpm.JavaEsame.Data;

import java.util.ArrayList;

import it.univpm.JavaEsame.Model.ServiziPostali;

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
