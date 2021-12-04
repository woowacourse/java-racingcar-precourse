package racingcar;

import camp.nextstep.edu.missionutils.Console;

class NameStringMaker {
	private String chunkOfCarNames;

	String getNameString() {
		return chunkOfCarNames;
	}

	NameStringMaker() {
		input();
	}

	private void input() {
		do {
			this.chunkOfCarNames = Console.readLine();
		} while (!isValidInput(chunkOfCarNames));
	}

	private boolean isValidInput(String input) {
		try {
			return new InputValidator().isStrContainOnlyAlphabetOrComma(input);
		} catch (Exception error) {
			System.out.println(error.getMessage());
			return false;
		}
	}
}