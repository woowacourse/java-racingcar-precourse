package racingcar.utils.validator;

import java.util.Arrays;
import java.util.HashSet;

public class CarNameValidator {
	private static final int NAME_LIMIT_LENGTH = 5;

	public void validateName(String[] carArray) {
		if (isEmptyName(carArray)) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름이 빈 문자열이어서는 안된다.");
		}
		if (isInvalidLength(carArray)) {
			throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5글자 이하여야 한다.");
		}
		if (existsDuplicateName(carArray)) {
			throw new IllegalArgumentException("[ERROR] 자동차에 중복된 이름이 포함되면 안된다.");
		}
	}

	private boolean isEmptyName(String[] carArray) {
		return !Arrays.stream(carArray)
			.allMatch(car -> car.length() > 0);
	}

	private boolean isInvalidLength(String[] carArray) {
		return !Arrays.stream(carArray)
			.allMatch(car -> car.length() < NAME_LIMIT_LENGTH);
	}

	private boolean existsDuplicateName(String[] carArray) {
		return !Arrays.stream(carArray)
			.allMatch(new HashSet<>()::add);
	}
}
