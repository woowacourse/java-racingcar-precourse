package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryNumberValidator;

public class Input {
	static final String MSG_GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	static final String MSG_GET_TRY_NUM = "시도할 회수는 몇회인가요?";
	static final String SPLIT_REGEX = ",";

	public static String[] carName() {
		String[] carNames;
		do {
			System.out.println(MSG_GET_CAR_NAME);
			carNames = Console.readLine().split(SPLIT_REGEX);
			trimCarNames(carNames);
		} while (!checkCarNames(carNames));

		return carNames;
	}

	public static int tryNumber() {
		String tryNumber;
		do {
			System.out.println(MSG_GET_TRY_NUM);
			tryNumber = Console.readLine().trim();
		} while (!checkTryNumber(tryNumber));

		return Integer.parseInt(tryNumber);
	}

	private static void trimCarNames(String[] carNames) {
		for (int i = 0; i < carNames.length; i++) {
			carNames[i] = carNames[i].trim();
		}
	}

	private static boolean checkCarNames(String[] carNames) {
		try {
			CarNameValidator.checkAll(carNames);
			return true;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}

	private static boolean checkTryNumber(String tryNumber) {
		try {
			TryNumberValidator.checkAll(tryNumber);
			return true;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}
}
