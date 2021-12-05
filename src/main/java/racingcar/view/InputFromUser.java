package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.logic.InputExceptionHandling;

public class InputFromUser {
	private static final String INPUT_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_COUNT_MSG = "시도할 회수는 몇회인가요?";
	private static final String DELIMITER = ",";

	private final InputExceptionHandling inputExceptionHandling;

	public InputFromUser() {
		inputExceptionHandling = new InputExceptionHandling();
	}

	public String[] inputCarName() {
		System.out.println(INPUT_NAME_MSG);
		String names = Console.readLine();
		String[] carNames = names.split(DELIMITER);

		try {
			return inputExceptionHandling.validNameInput(carNames);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e);
			return inputCarName();
		}
	}

	public int inputGameCount() {
		System.out.println(INPUT_COUNT_MSG);
		String count = Console.readLine();

		try {
			return inputExceptionHandling.validCountInput(count);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e);
			return inputGameCount();
		}
	}
}
