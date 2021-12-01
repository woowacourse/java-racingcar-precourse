package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {
	static final String CAR_INPUT_STRING = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	
	public void start() {
		System.out.println(CAR_INPUT_STRING);
		String carInput = Console.readLine();
	}
}
