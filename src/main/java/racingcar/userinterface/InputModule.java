package racingcar.userinterface;

import camp.nextstep.edu.missionutils.Console;

class InputModule {
	private String innerValue;
	private final String regularExpression;
	private final String errorMessage;

	InputModule(String regularExpression, String errorMessage) {
		this.regularExpression = regularExpression;
		this.errorMessage = errorMessage;
		setValue();
	}

	public String getValue() {
		return innerValue;
	}

	private void setValue() {
		boolean passed = false;
		while (!passed) {
			try {
				initInner();
				passed = true;
			} catch (IllegalArgumentException Error) {
				System.out.println(Error.getMessage());
			}
		}
	}

	private void initInner() {
		String input = Console.readLine();
		if (!checkValid(input)) {
			throw new IllegalArgumentException(errorMessage);
		}
		this.innerValue = input;
	}

	private boolean checkValid(String string) {
		return string.matches(regularExpression);
	}
}
