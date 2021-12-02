package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final String ERROR_MESSAGE = "[ERROR]";

	public static String[] inputCarNames() {
		try {
			String[] names = Console.readLine().split(",");
			validateLengthOfCarName(names);
			return names;
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return inputCarNames();
		}
	}

	private static void validateLengthOfCarName(String[] names) {
		for (String name : names) {
			if (name.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE + "입력한 이름이 5글자를 초과합니다.");
			}
		}
	}
}
