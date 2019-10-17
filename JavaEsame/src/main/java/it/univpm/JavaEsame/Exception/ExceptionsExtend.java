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
	
	public String annoErr()
	{
		return "Controlla la console per maggiori informazioni sull'errore,\n"
	     		+ "oppure consulta gli esempi su come inserire correttamente le keys su Postman\n"
	     		+ "al link https://github.com/RiccardoMancini/oopJavaUnivpm#come-applicare-i-filtri-su-postman";
	}
	
	public String valErr()
	{
		return "Un value dell'attributo non è stato scritto correttamente!\n"
	     		+ "Visitare gli esempi al link https://github.com/RiccardoMancini/oopJavaUnivpm#come-applicare-i-filtri-su-postman \n"
	     		+ "per scriverlo correttamente.";
	}
	
	public String keyErr()
	{
		return  "Una key dell'attributo non è stata scritta correttamente!\n"
	      		+ "Visitare gli esempi al link https://github.com/RiccardoMancini/oopJavaUnivpm#come-applicare-i-filtri-su-postman \n"
	      		+ "per scriverlo correttamente.";
	}

	
}
