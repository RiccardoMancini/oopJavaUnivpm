package it.univpm.JavaEsame.Model;

public class Operation {

	private double avg;
	private double max;
	private double min;
	private double dev_std;
	private double sum;
	private int count;
	
	public Operation(double avg, double max, double min, double dev_std, double sum, int count)
	{
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.dev_std = dev_std;
		this.sum = sum;
		this.count = count;
	}

	public double getDev_std() {
		return dev_std;
	}

	public void setDev_std(double dev_std) {
		this.dev_std = dev_std;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	

	
}
