package algorithm;

public class KCluster extends weight {
	public int num;

	public KCluster(int length, boolean rnd, int num) {
		super(length, rnd);
		this.num = num;
	}

	public int getNumber() {
		return num;
	}

	public void setWeight(weight w) {
		value = w.value;
	}
}