package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constant;
import racingcar.constants.Message;

public class UserService {
	public String[] register() {
		String[] names = new String[]{};
		while (names.length == 0) {
			names = getCarNames();
		}

		return names;
	}

	private String[] getCarNames() {
		try {
			String input = Console.readLine();
			return getValidName(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR_INVALID_NAME_FORMAT);
			return new String[]{};
		}
	}

	private String[] getValidNames(String input) {
		String[] names = input.split(Constant.SPLIT_STRING);

		Verifier.checkLastIndex(input);
		Verifier.checkValidNames(names);

		return names;
	}

	public int howManyTimes() {
		int stage = Constant.INVALID_STAGE_NUMBER;
		while (stage == Constant.INVALID_STAGE_NUMBER) {
			stage = getStage();
		}

		return stage;
	}

	private int getStage() {
		try {
			String input = Console.readLine();
			return Verifier.checkValidStage(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR_INVALID_STAGE_VALUE);
			return Constant.INVALID_STAGE_NUMBER;
		}
	}
}
