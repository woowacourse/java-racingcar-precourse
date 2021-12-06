package racingcar.domain;

import static racingcar.resource.MessageResoruce.*;

public class CarName {
	private static final int LENGTH_MIN = 1;
	private static final int LENGTH_MAX = 5;

	private final String carName;

	public CarName(final String name) {
		if (name.length() < LENGTH_MIN) {
			throw new IllegalArgumentException(ERROR_CAR_NAME_SIZE_UNDER);
		}
		if (name.length() > LENGTH_MAX) {
			throw new IllegalArgumentException(ERROR_CAR_NAME_SIZE_OVER);
		}
		this.carName = name;
	}

	public String getCarName() {
		return carName;
	}
}
