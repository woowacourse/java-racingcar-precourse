package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private String DELIMITER = ",";
	private String INPUT_MESSAGE_CARNAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(" + DELIMITER + ") 기준으로 구분)";

	private String[] names;
	private int numberOfTimes;

	public void inputNames() {
		System.out.println(INPUT_MESSAGE_CARNAMES);
		String input = Console.readLine();
		names = input.split(DELIMITER);
	}
}
