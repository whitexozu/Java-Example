package streamExample;

public class Sttta implements Comparable<Sttta> {
	private String stttaid;
	private String regTime;
	private int sortNum;
	
	public Sttta(String stttaid, String regTime) {
		this.stttaid = stttaid;
		this.regTime = regTime;
	}
	public String getStttaid() {
		return stttaid;
	}
	public void setStttaid(String stttaid) {
		this.stttaid = stttaid;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public int getSortNum() {
		return sortNum;
	}
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
	
	@Override
	public int compareTo(Sttta o) {
		return this.getRegTime().compareTo(o.getRegTime());
	}
}
