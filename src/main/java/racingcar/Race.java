package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Race {
	int repeatNum;

	Race() {

	}

	class Round {
		void play() {

		}
	}

	private class NumberInitiator {
		String input;

		public int getNumber() {
			return Integer.parseInt(input);
		}

		NumberInitiator() {
			init();
		}

		void init() {
			boolean passed = false;
			while (!passed) {
				passed = tryToInputValidNumber();
			}
		}

		boolean tryToInputValidNumber() {
			try {
				input = Console.readLine();
				return isInputValid();
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
				return false;
			}
		}

		boolean isInputValid() {
			if (input.matches("^[1-9][0-9]*")) {
				return true;
			}
			throw new IllegalArgumentException("반복횟수는 숫자만 입력해야 합니다.");
		}
	}
}