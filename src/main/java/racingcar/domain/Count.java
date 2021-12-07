package racingcar.domain;

import java.util.Objects;

public class Count implements Comparable<Count> {
	private Integer count;

	public Count(Integer count) {
		this.count = count;
	}

	public static Count of(Integer count) {
		return new Count(count);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Count count1 = (Count)o;
		return Objects.equals(count, count1.count);
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}

	@Override
	public int compareTo(Count o) {
		return Integer.compare(o.count, o.getCount());
	}

	public int getCount() {
		return this.count;
	}

	public boolean isRacingEnd() {
		if (this.count > 0) {
			nextRacing();
			return true;
		}
		return false;
	}

	private void nextRacing() {
		this.count--;
	}
}
