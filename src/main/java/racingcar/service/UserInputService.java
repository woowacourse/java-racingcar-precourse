package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constant;
import racingcar.constants.Message;
import racingcar.utils.Validator;

public class UserInputService {
	private static UserInputService instance = new UserInputService();

	private UserInputService() {
	}

	public static UserInputService getInstance() {
		if (instance == null) {
			instance = new UserInputService();
		}

		return instance;
	}

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
			System.out.println(Message.START);
			return new String[]{};
		}
	}

	private String[] getValidNames(String input) {
		String[] names = input.trim().split(Constant.SPLIT_STRING);

		Validator.checkLastIndex(input);
		Validator.checkValidNames(names);

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
			return Validator.checkValidStage(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR_INVALID_STAGE_VALUE);
			System.out.println(Message.ASK_STAGES);
			return Constant.INVALID_STAGE_NUMBER;
		}
	}
}
