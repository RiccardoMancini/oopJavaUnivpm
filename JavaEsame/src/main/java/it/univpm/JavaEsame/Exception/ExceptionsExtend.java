package it.univpm.JavaEsame.Exception;

public class ExceptionsExtend extends Exception{
	
	private String detail;
	
	public ExceptionsExtend(String a){
		
		detail = a;
		
	}

	public ExceptionsExtend(){
		
		super();
		
	}

	public String abortFileCreation()
	{
		return "URL NON VALIDO!\n"
				+ "DOWNLOAD DATASET NON RIUSCITO!";
	}
	
	
	public String annoExc() {
		return "ANNO INSERITO:"+detail+" NON CORRETTO!\n"
				+ "INSERIRE UN ANNO COMPRESO TRA 2012 E 2017 INCLUSI!";
	}

	
}
