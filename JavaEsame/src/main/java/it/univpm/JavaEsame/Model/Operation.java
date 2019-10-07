package it.univpm.JavaEsame.Model;

public class Operation {

	private float avg;
	private float max;
	private float min;
	private float dev_std;
	private float sum;
	private int count;
	
	public Operation(float avg, float max, float min, float dev_std, float sum, int count)
	{
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.dev_std = dev_std;
		this.sum = sum;
		this.count = count;
	}

	public float getDev_std() {
		return dev_std;
	}

	public void setDev_std(float dev_std) {
		this.dev_std = dev_std;
	}

	public float getSum() {
		return sum;
	}

	public void setSum(float sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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
