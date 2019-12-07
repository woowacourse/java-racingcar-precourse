package domain;

public class TrialCount {
	private static final int END = 0;

	private int count;

	public TrialCount(int count) {
		this.count = count;
	}

	public boolean hasNext() {
		return count > END;
	}

	public void next() {
		count--;
	}
}
