package it.univpm.JavaEsame.ManagingData;

import java.util.ArrayList;
import it.univpm.JavaEsame.Model.Metadata;

public class ArrayMetadata {				//Classe contenente un ArrayList di Metadata
	
	private ArrayList<Metadata> arrayMetadata;
	
	public ArrayMetadata()					//Costruttore che inizializza l'Arraylist, aggiungendoci poi i metadati esistenti
	{
		arrayMetadata = new ArrayList<Metadata>();
		arrayMetadata.add(new Metadata("Freq","Frequenza","String"));
		arrayMetadata.add(new Metadata("Unit","Unità di misura","String"));
		arrayMetadata.add(new Metadata("Indic_ps","Indicatore statistiche postali","String"));
		arrayMetadata.add(new Metadata("Geo","Paese","String"));
		arrayMetadata.add(new Metadata("2012","2012","Double"));
		arrayMetadata.add(new Metadata("2013","2013","Double"));
		arrayMetadata.add(new Metadata("2014","2014","Double"));
		arrayMetadata.add(new Metadata("2015","2015","Double"));
		arrayMetadata.add(new Metadata("2016","2016","Double"));
		arrayMetadata.add(new Metadata("2017","2017","Double"));
		
		
	}

	public ArrayList<Metadata> getArrayMetadata() {
		return arrayMetadata;
	}

	
}
