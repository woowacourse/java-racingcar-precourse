package racingcar.domain;

import static racingcar.resource.MessageResoruce.*;

import org.junit.platform.commons.util.StringUtils;

public class CarName {
	private static final int LENGTH_MAX = 5;

	private final String carName;

	public CarName(String name) {
		if (name.isEmpty() || StringUtils.isBlank(name)) {
			throw new IllegalArgumentException(ERROR_CAR_NAME_NOT_EMPTY);
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
