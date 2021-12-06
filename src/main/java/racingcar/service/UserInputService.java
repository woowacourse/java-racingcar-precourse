package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constant;
import racingcar.constants.Message;
import racingcar.utils.Verifier;

public class UserInputService {
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
			return getValidNames(input);
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
		System.out.println(Message.ASK_STAGES);

		int stage = Constant.INVALID_STAGE_NUMBER;
		while (stage == Constant.INVALID_STAGE_NUMBER) {
			stage = getValidStage();
		}

		return stage;
	}

	private int getValidStage() {
		try {
			String input = Console.readLine();
			return Verifier.checkValidStage(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR_INVALID_STAGE_VALUE);
			return Constant.INVALID_STAGE_NUMBER;
		}
	}
}
