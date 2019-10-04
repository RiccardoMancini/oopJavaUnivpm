package it.univpm.JavaEsame.Data;

public class ServiziPostali {
	
	private String Freq;
	private String Unit;
	private String Indic_ps;
	private String Geo;
	private float[] Anni;
	
	public ServiziPostali(String Freq, String Unit, String Indic_ps, String Geo, float[] Anni)
	{
		this.Freq = Freq;
		this.Unit = Unit;
		this.Indic_ps = Indic_ps;
		this.Geo = Geo;
		this.Anni = Anni;
	}

	public String getFreq() {
		return Freq;
	}


	public String getUnit() {
		return Unit;
	}


	public String getIndic_ps() {
		return Indic_ps;
	}



	public String getGeo() {
		return Geo;
	}

	
	public float[] getAnni() {
		return Anni;
	}

}
