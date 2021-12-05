package racingcar.utils.reader;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Const;
import racingcar.utils.validator.RoundValidator;

public class RoundReader {
	public static int readRound() {
		System.out.println(Const.ROUND_INPUT_MESSAGE);
		String userInput = Console.readLine();
		int result;
		try {
			result = RoundValidator.validate(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readRound();
		}

		return result;
	}
}
