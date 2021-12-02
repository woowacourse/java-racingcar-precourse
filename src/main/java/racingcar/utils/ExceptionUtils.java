package racingcar.utils;

import java.util.List;
import java.util.Objects;

public class ExceptionUtils {

	private static final int CAR_NAME_MINIMUM_LENGTH = 0;
	private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
	private static final String ERROR_HEADER = "[ERROR] ";
	private static final String LENGTH_ERROR_MESSAGE = "잘못된 차량의 길이가 입력되었습니다.";
	private static final String DUPLICATE_ERROR_MESSAGE = "중복된 차량의 이름이 입력되었습니다.";
	private static final String SPACE_ERROR_MESSAGE = "공백이 입력되었습니다.";

	private ExceptionUtils() {
	}

	public static void validateCarNames(List<String> carNames) {
		if (!checkDuplicatedCarName(carNames)) {
			throw new IllegalArgumentException(ERROR_HEADER + DUPLICATE_ERROR_MESSAGE);
		}
		for (String carName : carNames) {
			if (!checkCarNameLength(carName)) {
				throw new IllegalArgumentException(ERROR_HEADER + LENGTH_ERROR_MESSAGE);
			}
			if (!checkCarNameContainsSpace(carName)) {
				throw new IllegalArgumentException(ERROR_HEADER + SPACE_ERROR_MESSAGE);
			}
		}
	}

	public static boolean checkCarNameLength(String carName) {
		return carName.length() > CAR_NAME_MINIMUM_LENGTH
			&& carName.length() <= CAR_NAME_MAXIMUM_LENGTH;
	}

	public static boolean checkDuplicatedCarName(List<String> carNames) {
		return carNames.stream().distinct().count() == carNames.size();
	}

	public static boolean checkCarNameContainsSpace(String carName) {
		return Objects.equals(carName, carName.replace(" ", ""));
	}

}
