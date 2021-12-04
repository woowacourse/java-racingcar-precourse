package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private String INPUT_CARNAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

	private String carNames;
	private int numberOfTimes;

	public void inputCarNames() {
		System.out.println(INPUT_CARNAMES_MESSAGE);
		carNames = Console.readLine();
	}
}
