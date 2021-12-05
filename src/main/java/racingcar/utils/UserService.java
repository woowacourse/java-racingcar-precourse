package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constant;
import racingcar.constants.Message;

public class UserService {
	public String[] register() {
		String[] names = new String[]{Constant.EMPTY};

		while (names[0].equals(Constant.EMPTY)) {
			names = getCarNames();
		}

		return names;
	}

	private String[] getCarNames() {
		String[] names;
		try {
			names = getValidName();
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR_INVALID_NAME_FORMAT);
			return new String[]{Constant.EMPTY};
		}

		return names;
	}

	private String[] getValidName() {
		String input = Console.readLine();
		String[] names = input.split(Constant.SPLIT_STRING);

		checkLastIndex(input);
		checkValidName(names);

		return names;
	}

	private void checkValidName(String[] names) {
		Set<String> checker = new HashSet<>();
		for (String name : names) {
			if (!isValidNameLength(name) || !checker.add(name)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private boolean isValidNameLength(String name) {
		return Constant.MIN_NAME_LENGTH <= name.length() && name.length() <= Constant.MAX_NAME_LENGTH;
	}

	private void checkLastIndex(String userInput) {
		if (userInput.lastIndexOf(Constant.IMPROPER_CHARACTER) == userInput.length() - 1) {
			throw new IllegalArgumentException();
		}
	}

	public int howManyTimes() {
		int stage = Constant.INVALID_STAGE_NUMBER;
		while (stage == Constant.INVALID_STAGE_NUMBER) {
			stage = getStage();
		}
		return stage;
	}

	private int getStage() {
		int stage;
		try {
			String input = Console.readLine();
			stage = getValidStage(input);
		} catch (IllegalArgumentException e) {
			System.out.println(Message.ERROR_INVALID_STAGE_VALUE);
			return Constant.INVALID_STAGE_NUMBER;
		}
		return stage;
	}

	private int getValidStage(String input) {
		if (input.chars().allMatch(Character::isDigit)) {
			return Integer.parseInt(input);
		}
		return Constant.INVALID_STAGE_NUMBER;
	}
}
