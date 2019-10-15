package it.univpm.JavaEsame.ManagingData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

import it.univpm.JavaEsame.Exception.ExceptionsExtend;

public class Buffer {						//Classe che decodifica il JSON e scarica il dataset CSV

	private BufferedReader br;
	private String lstr;
	private String filename;
	
	
	public Buffer(URL url) {		//Metodo che mette in una stringa tutto il JSON da elaborare	
		try {
		this.lstr = "";
		String str = "";
		br = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((str = br.readLine()) != null) {
			
			lstr += str;
		
		}
		br.close();
		}catch(Exception e) {System.out.println(new ExceptionsExtend().abortFileCreation());
								 System.exit(1); }
		
		
	}
	
	public String file() throws  IOException
	{
		this.filename = "dataset.csv";
		
		JSONObject obj= new JSONObject(lstr);
		JSONArray arr = obj.getJSONObject("result").getJSONArray("resources");
		String dataset_url = arr.getJSONObject(6).getString("url");
		
		URL url2 = new URL(dataset_url);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(url2.openStream()));
		PrintWriter writer = new PrintWriter(filename);
		String str = "";
		while((str = br2.readLine()) != null) {
			
	    	if(!str.isEmpty()) {

	    		writer.println(str.trim());
	    	}
			
		}
		
		br2.close();
		writer.close();
		
		
		return filename;
		
		
	}
}
