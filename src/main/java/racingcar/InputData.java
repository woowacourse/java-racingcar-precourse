package racingcar;

import camp.nextstep.edu.missionutils.Console;

class InputData {
	private static final char MINUS_SIGN = '-';
	private static final String SEPARATOR = ",";

	private static final int NAME_MAX_LIMIT = 5;
	private static final int NAME_MIN_LIMIT = 0;
	private static final int TIMES_MIN_LIMIT = 0;

	private static final String ERROR_MORE_THAN_FIVE = "[ERROR] 5자 이하의 이름을 입력해주세요.";
	private static final String ERROR_DIGIT_FALSE = "[ERROR] 시도 횟수는 숫자로만 입력해주세요.";
	private static final String ERROR_LESS_THAN_ZERO = "[ERROR] 0보다 큰 정수를 입력해주세요.";

	private static final String PLEASE_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 공백없는 쉼표(,) 기준으로 구분)";
	private static final String PLEASE_INPUT_NUMBER_OF_TIMES = "시도할 회수는 몇회인가요?";

	private static boolean checkMoreThanFive(String[] names, boolean MoreThanFive) {
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() > NAME_MAX_LIMIT) {
				MoreThanFive = true;
				break;
			}
		}

		try {
			if (MoreThanFive == true) {
				throw new IllegalArgumentException(ERROR_MORE_THAN_FIVE);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		return MoreThanFive;
	}

	public static String[] getCarName() {
		String[] names;
		boolean MoreThanFive = false;
		do {
			System.out.println(PLEASE_INPUT_CAR_NAME);
			names = Console.readLine().split(SEPARATOR);
		} while (checkMoreThanFive(names, MoreThanFive) == true);

		return names;
	}

	private static int checkLessThanZero(int number) {
		System.out.println(PLEASE_INPUT_NUMBER_OF_TIMES);
		String input = Console.readLine();
		boolean digitCheck = true;
		for (int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			if (tmp == MINUS_SIGN) {
				continue;
			}
			if (Character.isDigit(tmp) == false) {
				digitCheck = false;
				break;
			}
		}

		try {
			if (digitCheck == false) {
				throw new IllegalArgumentException(ERROR_DIGIT_FALSE);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

			return number;
		}

		try {
			number = Integer.parseInt(input);
			if (number <= NAME_MIN_LIMIT) {
				throw new IllegalArgumentException(ERROR_LESS_THAN_ZERO);
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		return number;
	}

	public static int getNumberOfTimes() {
		int number = -1;

		while (number <= TIMES_MIN_LIMIT) {
			number = checkLessThanZero(number);
		}

		return number;
	}
}
