package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private int MAX_CAR_NAME_LENGTH = 5;
	private int MIN_CAR_NAME_LENGTH = 1;

	private String DELIMITER = ",";
	private String INPUT_MESSAGE_CARNAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)";
	private String ERROR = "[ERROR]";
	private String ERROR_MESSAGE_CAR_NAME_LENGTH =
		ERROR + "자동차 이름은 " + MIN_CAR_NAME_LENGTH + "자 이상 " + MAX_CAR_NAME_LENGTH + "자 이하만 가능합니다.";

	private String[] names;
	private int numberOfTimes;

	public void inputNames() {
		System.out.println(INPUT_MESSAGE_CARNAMES);
		String input = Console.readLine();
		names = input.split(DELIMITER);
	}

	public boolean checkNames() {
		try {
			checkNamesLength();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private void checkNamesLength() {
		for (String name : names) {
			if (name.length() > MAX_CAR_NAME_LENGTH || name.length() < MIN_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_LENGTH);
			}
		}
	}
}
