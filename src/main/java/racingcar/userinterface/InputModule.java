package racingcar.userinterface;

import camp.nextstep.edu.missionutils.Console;

class InputModule {
	private String innerValue;
	private String noticeMessage;
	private String regularExpression;
	private String errorMessage;

	InputModule(String noticeMessage, String regularExpression, String errorMessage) {
		this.noticeMessage = noticeMessage;
		this.regularExpression = regularExpression;
		this.errorMessage = errorMessage;
	}

	String getValue() {
		System.out.println(noticeMessage);
		setValue();
		return innerValue;
	}

	private void setValue() {
		boolean passed = false;
		while (!passed) {
			initInner();
			passed = true;
		}
	}

	private void initInner() {
		String input = Console.readLine();
		if (checkValid(input)) {
			this.innerValue = input;
		}
		throw new IllegalArgumentException(errorMessage);
	}

	private boolean checkValid(String string) {
		return string.matches(regularExpression);
	}
}
