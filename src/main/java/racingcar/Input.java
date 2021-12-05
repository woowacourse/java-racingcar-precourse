package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	static final int CAR_NAME_LENGTH = 5;

	public static String[] carName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] carNames;

		while(true){
			carNames = Console.readLine().split(", +");
			try {
				checkCarNames(carNames);
				break;
			} catch (IllegalArgumentException exception){ }
		}

		return carNames;
	}

	public static int tryNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String number = Console.readLine();

		// validate isNumber

		return Integer.parseInt(number);
	}

	private static void checkCarNames(String[] carNames) {
		for (String carName : carNames) {
			// validate length
			// validate isSpace
		}
	}
}
