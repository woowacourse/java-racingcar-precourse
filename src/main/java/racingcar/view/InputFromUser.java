package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.logic.InputValidator;

public class InputFromUser {
	private static final String INPUT_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_COUNT_MSG = "시도할 회수는 몇회인가요?";
	private static final String DELIMITER = ",";

	private final InputValidator inputValidator;

	public InputFromUser() {
		inputValidator = new InputValidator();
	}

	public String[] inputCarName() {
		System.out.println(INPUT_NAME_MSG);
		String names = Console.readLine();
		String[] carNames = names.split(DELIMITER);

		if (inputValidator.validNameInput(carNames)) {
			return carNames;
		}
		return inputCarName();
	}

	public int inputGameCount() {
		System.out.println(INPUT_COUNT_MSG);
		String count = Console.readLine();

		int intCount = inputValidator.validCountInput(count);
		if (intCount > 0) {
			return intCount;
		}
		return inputGameCount();
	}
}
