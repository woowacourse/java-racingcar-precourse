package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;

public class InputView {
	private static final String RACING_INFORMATION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String NUMBER_OF_TRIAL = "시도할 회수는 몇회인가요?";

	public static String[] getInputRaceCar() {
		while (true) {
			try {
				System.out.println(RACING_INFORMATION);
				String inputCarNames = Console.readLine();

				return InputException.isValidCarNames(inputCarNames);

			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}

		}

	}

	public static int getInputTrial() {
		while (true) {
			try {
				System.out.println(NUMBER_OF_TRIAL);
				return InputException.isValidInputTrial(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
