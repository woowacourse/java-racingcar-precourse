package domain;

import java.util.Objects;

public class Position {
	private static final int MOVE_DISTANCE = 1;

	private final int position;

	public Position() {
		this.position = 0;
	}

	private Position(int position) {
		this.position = position;
	}

	public Position increase() {
		return new Position(this.position + MOVE_DISTANCE);
	}

	public int toInt() {
		return this.position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Position otherPosition = (Position)o;
		return position == otherPosition.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
