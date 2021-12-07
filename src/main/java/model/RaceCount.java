package model;

public class RaceCount {
	private static final int ONE_RACE_COUNT = 1;
	private static final int END_RACE_COUNT = 0;
	private int count;

	public RaceCount(int count) {
		this.count = count;
	}

	public void decrementCount() {
		count -= ONE_RACE_COUNT;
	}

	public boolean isNotRaceEnd() {
		if (count != END_RACE_COUNT) {
			return true;
		}
		return false;
	}
}
