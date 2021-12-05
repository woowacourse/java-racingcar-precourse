package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private InputView() {
	}

	private String[] getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String[] carNames = Console.readLine().split(",");
		try {
			validateCarName(carNames);
		} catch (Exception exception) {
			System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
			getCarNames();
		}
		return carNames;
	}

	private void validateCarName(String[] carNames) {
		for (String car : carNames) {
			if (car.length() >= MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException();
			}
		}
	}

	public int getMoveTimes() {
		System.out.println("시도할 회수는 몇회인가요?");
		String moveTimes = Console.readLine();
		try {
			validateMoveTimes(moveTimes);
		} catch (Exception exception) {
			System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다.");
			getMoveTimes();
		}
		return Integer.parseInt(moveTimes);
	}

	private void validateMoveTimes(String moveTimes) {
		try {
			Integer.parseInt(moveTimes);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}

	}
}
