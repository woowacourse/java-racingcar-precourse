package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ERROR = "[ERROR]";

	public String enterCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}

	public String enterNumberOfAttempts() {
		System.out.println("시도할 회수는 몇회인가요?");
		String numberOfAttempts = Console.readLine();

		try {
			isAttemptsNotInteger(numberOfAttempts);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR + " " + e.getMessage());
			numberOfAttempts = enterNumberOfAttempts();
		}

		return numberOfAttempts;
	}

	protected void isAttemptsNotInteger(String numberOfAttempts) {
		if (!numberOfAttempts.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
		}
	}
}
