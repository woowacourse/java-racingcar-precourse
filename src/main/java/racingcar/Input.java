package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	static final int CAR_NAME_LENGTH = 5;

	public static String[] carName() {
		String[] carNames;

		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			carNames = Console.readLine().split(", +");
		} while (!checkCarNames(carNames));

		return carNames;
	}

	public static int tryNumber() {
		String number;

		do {
			System.out.println("시도할 회수는 몇회인가요?");
			number = Console.readLine();
		} while(!checkTryNumber(number));

		return Integer.parseInt(number);
	}

	private static boolean checkCarNames(String[] carNames) {
		try {
			for (String carName : carNames) {
				Validation.validateLength(carName, CAR_NAME_LENGTH);
				Validation.validateEmpty(carName);
			}
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}

	private static boolean checkTryNumber(String number) {
		try {
			Validation.validateIsInteger(number);
			Validation.validateIsPositiveInteger(number);
			return true;
		} catch (IllegalArgumentException exception) {
			return false;
		}
	}
}
