package it.univpm.JavaEsame.Model;

public class Operation {

	private float avg;
	private float max;
	private float min;
	
	public Operation(float avg, float max, float min)
	{
		this.avg = avg;
		this.max = max;
		this.min = min;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	

	
}
