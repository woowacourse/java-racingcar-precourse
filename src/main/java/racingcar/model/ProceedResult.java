package racingcar.model;

import java.util.Objects;

public class ProceedResult {
	private final String name;
	private final int position;

	public ProceedResult(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static ProceedResult of(String name, int position) {
		return new ProceedResult(name, position);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProceedResult that = (ProceedResult) o;
		return position == that.position && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, position);
	}
}
