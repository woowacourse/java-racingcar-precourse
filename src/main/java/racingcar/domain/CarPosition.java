package racingcar.domain;

import java.util.Objects;

public class CarPosition {
	public int position;

	public CarPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return this.position;
	}

	public CarPosition forward() {
		return new CarPosition(position + 1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CarPosition that = (CarPosition)o;
		return position == that.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
