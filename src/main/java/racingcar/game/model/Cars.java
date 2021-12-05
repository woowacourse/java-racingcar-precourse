package racingcar.game.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import racingcar.common.message.ExceptionMessage;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		isDuplicateName(cars);
		this.cars = cars;
	}

	private void isDuplicateName(final List<Car> cars) {
		if (Arrays.stream(cars.toArray()).distinct().count() != cars.size()) {
			throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE.getMessage());
		}

	}

	public void attemptMove() {
		for (Car car : cars) {
			car.attemptMoveThrough();
		}

	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(cars);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Cars cars = (Cars)o;
		return Objects.equals(this.cars, cars.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}

}
