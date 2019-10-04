package it.univpm.JavaEsame.Data;

import java.util.ArrayList;
import it.univpm.JavaEsame.Model.Metadata;

public class ArrayMetadata {
	
	private ArrayList<Metadata> arrayMetadata = new ArrayList<Metadata>();
	
	public ArrayMetadata()
	{
		arrayMetadata.add(new Metadata("Freq","Frequenza","String"));
		arrayMetadata.add(new Metadata("Unit","Unità di misura","String"));
		arrayMetadata.add(new Metadata("Indic_ps","Indicatore statistiche postali","String"));
		arrayMetadata.add(new Metadata("Geo","Paese","String"));
		arrayMetadata.add(new Metadata("2012","2012","Float"));
		arrayMetadata.add(new Metadata("2013","2013","Float"));
		arrayMetadata.add(new Metadata("2014","2014","Float"));
		arrayMetadata.add(new Metadata("2015","2015","Float"));
		arrayMetadata.add(new Metadata("2016","2016","Float"));
		arrayMetadata.add(new Metadata("2017","2017","Float"));
		
		
	}

	public ArrayList<Metadata> getArrayMetadata() {
		return arrayMetadata;
	}

	
}
