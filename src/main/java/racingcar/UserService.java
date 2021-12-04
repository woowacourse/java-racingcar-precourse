package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constants.Constant;
import racingcar.constants.Message;

import java.util.HashSet;
import java.util.Set;

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
		checkNameLength(names);
		checkDuplicate(names);

		return names;
	}

	private void checkDuplicate(String[] names) {
		Set<String> check = new HashSet<>();
		for (String name : names) {
			if (!check.add(name)) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkNameLength(String[] names) {
		for (String name : names) {
			if (!(Constant.MIN_NAME_LENGTH <= name.length() && name.length() <= Constant.MAX_NAME_LENGTH)) {
				throw new IllegalArgumentException();
			}
		}
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
