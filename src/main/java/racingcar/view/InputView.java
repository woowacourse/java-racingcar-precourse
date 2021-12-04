package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Validation;

public class InputView {
	private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
	private static final String COMMA = ",";

	private final Validation validation;

	public InputView() {
		validation = new Validation();
	}

	public String[] carNames() {
		while (true) {
			System.out.println(CAR_NAME_INPUT_MESSAGE);
			try {
				String[] carNames = Console.readLine().split(COMMA);
				validation.isValid(carNames);
				return carNames;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String round() {
		while (true) {
			System.out.println(ROUND_INPUT_MESSAGE);
			try {
				String round = Console.readLine();
				validation.isValid(round);
				return round;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
