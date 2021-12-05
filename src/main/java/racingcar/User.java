package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private int MAX_NAME_LENGTH = 5;
	private int MIN_NAME_LENGTH = 1;

	private String DELIMITER = ",";
	private String INPUT_MESSAGE_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)";
	private String INPUT_MESSAGE_NUMBER_OF_TIMES = "시도할 회수는 몇회인가요?";
	private String ERROR = "[ERROR]";
	private String ERROR_MESSAGE_NAME_LENGTH =
		ERROR + "자동차 이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.";
	private String ERROR_MESSAGE_NAME_DUPLICATION = ERROR + "자동차 이름은 중복될 수 없습니다.";
	private String ERROR_MESSAGE_INPUT_IS_NOT_NUBMER = ERROR + "숫자를 입력해주세요.";

	private List<String> names;
	private int numberOfTimes;

	public void inputNamesUntilCorrect() {
		inputNames();
		while (!checkNames()) {
			inputNames();
		}
	}

	public void inputNames() {
		System.out.println(INPUT_MESSAGE_NAMES);
		String input = Console.readLine();
		names = Arrays.asList(input.split(DELIMITER, -1));
	}

	public boolean checkNames() {
		try {
			checkNamesLength();
			checkNamesDuplication();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkNamesLength() {
		for (String name : names) {
			if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
			}
		}
	}

	private void checkNamesDuplication() {
		Set<String> namesSet = new HashSet<>();
		for (String name : names) {
			if (namesSet.contains(name)) {
				throw new IllegalArgumentException(ERROR_MESSAGE_NAME_DUPLICATION);
			}
			namesSet.add(name);
		}
	}

	public int sizeOfNames() {
		return names.size();
	}

	public void inputAndSetNumberOfTimes() {
		System.out.println(INPUT_MESSAGE_NUMBER_OF_TIMES);
		String input = Console.readLine();
		setNumberOfTimes(input);
	}

	private void setNumberOfTimes(String input) {
		if (checkNumberOfTimes(input)) {
			this.numberOfTimes = Integer.valueOf(input);
		}
	}

	private boolean checkNumberOfTimes(String input) {
		try {
			checkInputIsNumber(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkInputIsNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!(input.charAt(i) >= 0 && input.charAt(i) <= 9)) {
				throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_IS_NOT_NUBMER);
			}
		}
	}
}
