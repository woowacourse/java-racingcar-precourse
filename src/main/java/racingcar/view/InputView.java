package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.type.RangeType;

public class InputView {

	private static final String NOT_DIGIT_OR_RANGE = "잘못된 입력입니다. 시도할 회수는 1이상의 숫자로만 입력해주세요.";
	private static final String DELIMITER = ",";

	public static String[] inputCarNames() {
		return Console.readLine().split(DELIMITER);
	}

	public static int inputGameRound() {
		String gameRound = Console.readLine();
		validateGameRound(gameRound);
		return Integer.parseInt(gameRound);
	}

	private static void validateGameRound(String gameRound) {
		if (!isDigit(gameRound) || isZeroRound(gameRound)) {
			throw new IllegalArgumentException(NOT_DIGIT_OR_RANGE);
		}
	}

	private static boolean isZeroRound(String gameRound) {
		return Integer.parseInt(gameRound) == RangeType.ZERO.getValue();
	}

	private static boolean isDigit(String gameRound) {
		for (char checkNumber : gameRound.toCharArray()) {
			if (!Character.isDigit(checkNumber)) {
				return false;
			}
		}
		return true;
	}
}
