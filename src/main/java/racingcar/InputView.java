package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine();
	}

	public String getNumberOfTimes() {
		System.out.println("시도할 회수는 몇회인가요?");
		String numberOfTimes = Console.readLine();
		if (isTimesNotInteger(numberOfTimes)) {
			throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
		}
		return numberOfTimes;
	}

	protected boolean isTimesNotInteger(String numberOfTimes) {
		return !numberOfTimes.chars().allMatch(Character::isDigit);
	}
}
