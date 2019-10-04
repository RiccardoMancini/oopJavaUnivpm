package it.univpm.JavaEsame.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parsing {
	
	private ArrayList<ServiziPostali> spost;
	private BufferedReader csvReader;
	private String str="";
	
	
	public Parsing(String filename) throws IOException {
		
		this.spost = ArrayData.getData();
		csvReader = new BufferedReader(new FileReader(filename));
		csvReader.readLine();
		while((str = csvReader.readLine()) != null)
		{
			String[] row = str.split("[;,]");
			
			spost.add(new ServiziPostali(row[0],row[1],row[2],row[3], 
					  				new float[] {new StringControl(row[4]).control(),
					  							 new StringControl(row[5]).control(),
					  							 new StringControl(row[6]).control(),
					  							 new StringControl(row[7]).control(),
					  							 new StringControl(row[8]).control(),
					  							 new StringControl(row[9]).control()}));
		}
		
		csvReader.close();
	
	}
	

	public String print()
	{
		
		return spost.get(2408).getFreq() + " "+spost.get(2408).getUnit() + " "+spost.get(2408).getIndic_ps() + " "+
			   spost.get(2408).getGeo() + " "+spost.get(2408).getAnni()[5] + "\n";
	}
}
