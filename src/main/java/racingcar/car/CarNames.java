package racingcar.car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class CarNames {
	private static final String DELIMITER = ",";
	private static final String EMPTY = "";
	private static final String SPACE = " ";
	private static final int MAX_SIZE = 5;
	private static final int NOTHING = 0;
	private static final String ERROR_NOTHING = "자동차는 최소 1개 이상 입력해야 합니다.";
	private static final String ERROR_EMPTY = "자동차 이름은 공백일 수 없습니다.";
	private static final String ERROR_LENGTH = "자동차 이름은 5자를 초과할 수 없습니다.";
	private static final String ERROR_CONTAIN_SPACE = "자동차 이름은 공백을 포함할 수 없습니다.";
	private static final String ERROR_DUPLICATE = "자동차 이름은 중복될 수 없습니다.";

	private List<String> names;

	public void input() {
		String input = Console.readLine();
		names = Arrays.asList(input.split(DELIMITER));
		validate();
	}

	private void validate() {
		validateNothing();
		validateEmpty();
		validateContainSpace();
		validateLength();
		validateDuplicate();
	}

	private void validateNothing() {
		if (names.size() == NOTHING) {
			throw new IllegalArgumentException(ERROR_NOTHING);
		}
	}

	private void validateEmpty() {
		if (names.contains(EMPTY)) {
			throw new IllegalArgumentException(ERROR_EMPTY);
		}
	}

	private void validateContainSpace() {
		if (names.stream().anyMatch(name -> name.contains(SPACE))) {
			throw new IllegalArgumentException(ERROR_CONTAIN_SPACE);
		}
	}

	private void validateLength() {
		if (names.stream().anyMatch(name -> name.length() > MAX_SIZE)) {
			throw new IllegalArgumentException(ERROR_LENGTH);
		}
	}

	private void validateDuplicate() {
		if (names.size() != names.stream().distinct().count()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE);
		}
	}

	public List<Car> generateCar() {
		return names.stream().map(Car::new).collect(Collectors.toList());
	}
}
