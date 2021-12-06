package model;

public class RaceCount {
	private static final int ONE_RACE_COUNT = 1;
	private int count;

	public RaceCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void decrementCount() {
		count -= ONE_RACE_COUNT;
	}
}
