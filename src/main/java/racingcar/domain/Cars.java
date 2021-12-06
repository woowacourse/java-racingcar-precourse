package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	public static final String NAME_DELIMITER = ",";
	public static final int MIN_PARTICIPANTS = 1;
	public static final int NAME_LENGTH_LIMIT = 6;

	public static final String EMPTY_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 비어있을 수 없습니다.";
	public static final String NAME_LENGTH_EXCEED_ERROR_MESSAGE = "[ERROR] 자동차 이름은 6자 미만입니다. ";
	public static final String DUPLICATED_NAME_ERROR_MESSAGE = "[ERROR] 자동차 이름은 중복될 수 없습니다.";
	public static final String ONLY_ONE_PARTICIPANT_ERROR_MESSAGE = "[ERROR] 둘 이상의 자동차 이름을 입력해주요.";

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
		validateEmptyName(carNameList);
		validateNameLengthExceed(carNameList);
		validateOnlyOneParticipant(carNameList);
		validateDuplicatedName(carNameList);
	}

	private static void validateEmptyName(String[] carNameList) {
		for (String carName : carNameList) {
			if (carName.length() == 0) {
				throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
			}
		}
	}

	private static void validateNameLengthExceed(String[] carNameList) {
		for (String carName : carNameList) {
			if (carName.length() >= NAME_LENGTH_LIMIT) {
				throw new IllegalArgumentException(NAME_LENGTH_EXCEED_ERROR_MESSAGE);
			}
		}
	}

	private static void validateOnlyOneParticipant(String[] carNameList) {
		if (carNameList.length <= MIN_PARTICIPANTS) {
			throw new IllegalArgumentException(ONLY_ONE_PARTICIPANT_ERROR_MESSAGE);
		}
	}

	private static void validateDuplicatedName(String[] carNameList) {
		Set<String> nameSet = new HashSet<>(Arrays.asList(carNameList));
		if (nameSet.size() != carNameList.length) {
			throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE);
		}
	}
}
