package it.univpm.JavaEsame.ManagingData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.univpm.JavaEsame.Model.ServiziPostali;

public class Parsing {
	
	private ArrayList<ServiziPostali> spost;
	private BufferedReader csvReader;
	private String str="";
	
	
	public Parsing()  {
		
		this.spost = new ArrayList<ServiziPostali>();                    
		
	
	}
	
	public void parser(String filename) throws IOException
	{
		                    
		this.csvReader = new BufferedReader(new FileReader(filename));
		csvReader.readLine();
		while((str = csvReader.readLine()) != null)
		{
			String[] row = str.split("[;,]");
			
			
			spost.add(new ServiziPostali(row[0],row[1],row[2],row[3], 
					  				new double[] {new StringControl(row[4]).control(),
					  							 new StringControl(row[5]).control(),
					  							 new StringControl(row[6]).control(),
					  							 new StringControl(row[7]).control(),
					  							 new StringControl(row[8]).control(),
					  							 new StringControl(row[9]).control()}));
			
			
			ArrayData.setData(spost);                                                      // Very importante!!!!!!!!
			
			
		}
		
		csvReader.close();
	}
	
}
