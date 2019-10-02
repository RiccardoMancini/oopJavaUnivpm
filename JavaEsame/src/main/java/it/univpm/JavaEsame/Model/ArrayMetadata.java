package it.univpm.JavaEsame.Model;

import java.util.ArrayList;

public class ArrayMetadata {
	
	private ArrayList<Metadata> arrayMetadata = new ArrayList<Metadata>();
	
	public ArrayMetadata()
	{
		arrayMetadata.add(new Metadata("Freq","Frequenza","String"));
		arrayMetadata.add(new Metadata("Unit","Unità di misura","String"));
		arrayMetadata.add(new Metadata("Indic_ps","Indicatore statistiche postali","String"));
		arrayMetadata.add(new Metadata("Geo","Paese","String"));
		arrayMetadata.add(new Metadata("2012","2012","String"));
		arrayMetadata.add(new Metadata("2013","2013","String"));
		arrayMetadata.add(new Metadata("2014","2014","String"));
		arrayMetadata.add(new Metadata("2015","2015","String"));
		arrayMetadata.add(new Metadata("2016","2016","String"));
		arrayMetadata.add(new Metadata("2017","2017","String"));
		
		
	}

	public ArrayList<Metadata> getArrayMetadata() {
		return arrayMetadata;
	}

	
}
