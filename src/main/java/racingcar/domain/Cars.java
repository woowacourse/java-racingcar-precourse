package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	public static final String NAME_DELIMITER = ",";

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars generateCars(String carNames) {
		String[] carNameList = carNames.split(NAME_DELIMITER);
		validate(carNameList);

		List<Car> carList = new ArrayList<>();
		for (String carName : carNameList) {
			carList.add(new Car(carName));
		}

		return new Cars(carList);
	}

	private static void validate(String[] carNameList) {
		validateNameLength(carNameList);
		validateOnlyOneParticipant(carNameList);
		validateDuplicatedName(carNameList);
	}

	private static void validateNameLength(String[] carNameList) {
		for (String carName : carNameList) {
			if (carName.length() <= 0) {
				throw new IllegalArgumentException();
			}

			if (carName.length() >= 6) {
				throw new IllegalArgumentException();
			}
		}
	}

	private static void validateOnlyOneParticipant(String[] carNameList) {
		if (carNameList.length == 1) {
			throw new IllegalArgumentException();
		}
	}

	private static void validateDuplicatedName(String[] carNameList) {
		Set<String> nameSet = new HashSet<>(Arrays.asList(carNameList));
		if (nameSet.size() != carNameList.length) {
			throw new IllegalArgumentException();
		}
	}
}
