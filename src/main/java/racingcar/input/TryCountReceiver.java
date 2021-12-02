package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.TryCountValidator;

public class TryCountReceiver {

	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String TRY_COUNT_ERROR_MESSAGE = "[ERROR] 시도 횟수의 값이 적절하지 않습니다.";

	TryCountValidator tryCountValidator = new TryCountValidator();

	public Integer receive() {
		String tryCountString = null;

		boolean errorSwitch = true;
		while (errorSwitch) {
			System.out.println(INPUT_TRY_COUNT_MESSAGE);
			tryCountString = Console.readLine();

			try {
				tryCountValidator.validate(tryCountString);
				errorSwitch = false;

				// 공백 라인 출력
				System.out.println();
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(TRY_COUNT_ERROR_MESSAGE);
				errorSwitch = true;
			}
		}

		return Integer.parseInt(tryCountString);
	}
}
