package it.univpm.JavaEsame.Model;

public class ServiziPostali {
	
	private String Freq;
	private String Unit;
	private String Indicps;
	private String Geo;
	private double[] Anni;
	
	public ServiziPostali(String Freq, String Unit, String Indicps, String Geo, double[] Anni)
	{
		this.Freq = Freq;
		this.Unit = Unit;
		this.Indicps = Indicps;
		this.Geo = Geo;
		this.Anni = Anni;
	}

	public String getFreq() {
		return Freq;
	}


	public String getUnit() {
		return Unit;
	}


	public String getIndicps() {
		return Indicps;
	}



	public String getGeo() {
		return Geo;
	}

	
	public double[] getAnni() {
		return Anni;
	}

}
