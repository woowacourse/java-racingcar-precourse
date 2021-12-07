package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryNumberValidator;

public class Input {
	public static String[] carName() {
		String[] carNames;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = Console.readLine().split(",");
			trimCarNames(carNames);
		} while (!checkCarNames(carNames));

		return carNames;
	}

	public static int tryNumber() {
		String tryNumber;
		do {
			System.out.println("시도할 회수는 몇회인가요?");
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
