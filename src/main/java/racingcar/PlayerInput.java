package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PlayerInput {
	private static final int MAX_NAME_SIZE = 5;
	private static final String INPUT_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_MESSAGE_MOVE_TRIAL_COUNT = "시도할 회수는 몇회인가요?";
	private static final String ERROR_MESSAGE_NAME_SIZE = "[ERROR] 이름은 최대 5자 입력 가능.";
	private static final String ERROR_MESSAGE_NOT_INT = "[ERROR] 시도 회수는 숫자만 입력 가능.";

	public List<String> getCarNames() {
		String input = getInputByMessage(INPUT_MESSAGE_CAR_NAMES);
		List<String> carNames = convertInputToCarNamesList(input);
		return carNames;
	}

	public int getMoveTrialCount() {
		String input = getInputByMessage(INPUT_MESSAGE_MOVE_TRIAL_COUNT);
		int count = convertInputToCount(input);
		return count;
	}

	private String getInputByMessage(String message) {
		System.out.println(message);
		String input = Console.readLine();
		return input;
	}

	private List<String> convertInputToCarNamesList(String input) {
		List<String> carNames = new ArrayList<>();
		StringTokenizer stringTokenizer = new StringTokenizer(input, ",");
		while (stringTokenizer.hasMoreTokens()) {
			String newName = stringTokenizer.nextToken();
			validateNameSize(newName);
			carNames.add(newName);
		}
		return carNames;
	}

	private int convertInputToCount(String input) {
		validateInputIsInt(input);
		return Integer.parseInt(input);
	}

	private void validateNameSize(String name) {
		if (name.length() > MAX_NAME_SIZE) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NAME_SIZE);
		}
	}

	private void validateInputIsInt(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				throw new IllegalArgumentException(ERROR_MESSAGE_NOT_INT);
			}
		}
	}
}
