package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Constant;
import racingcar.utils.Validation;

public class User {
	public static String[] carNameInput() {
		String[] carNames = new String[3];
		do {
			System.out.println(Constant.ASK_CARS_NAME);
			String carNameInput = Console.readLine();
			carNames = carNameInput.split(",");
		} while (!checkRightNames(carNames));

		return carNames;
	}

	public static int gameCountInput() {
		String stringGameCount = "";
		int gameCount = 0;

		do {
			System.out.println(Constant.ASK_GAME_COUNT);
			stringGameCount = Console.readLine();
		} while (!checkRightGameCount(stringGameCount));

		gameCount = Integer.parseInt(stringGameCount);
		System.out.println();
		return gameCount;
	}

	public static boolean checkRightNames(String[] carNames) {
		boolean isRightNames = true;
		try {
			Validation.CONTAIN_SAME_NAME_ERROR(carNames);
			Validation.WHITE_SPACE_NAME_ERROR(carNames);
			Validation.LESS_MORE_NAME_ERROR(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			isRightNames = false;
		}
		return isRightNames;
	}

	public static boolean checkRightGameCount(String stringGameCount) {
		boolean isRightNumeric = true;
		try {
			Validation.NON_NUMERIC_GAME_COUNT_ERROR(stringGameCount);
			Validation.ZERO_GAME_COUNT_ERROR(stringGameCount);
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
			isRightNumeric = false;
		}
		return isRightNumeric;

	}
}
