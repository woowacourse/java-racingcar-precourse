package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ERROR_MESSAGE = "[ERROR] ";

	public List<String> getCarNames() {
		try {
			System.out.println(ENTER_CAR_NAMES);
			return NameGenerator.generateNames(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
			return getCarNames();
		}
	}
}
