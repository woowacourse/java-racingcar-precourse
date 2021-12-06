package model;

public class RaceCount {
	private int count;

	public RaceCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void decrementCount() {
		count -= 1;
	}
}
