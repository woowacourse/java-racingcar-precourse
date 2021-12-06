package racingcar.userinterface;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	
	class CarNames {
		private String carNames;

		String getCarNames() {
			return carNames;
		}

		void initCars() {
			String input = Console.readLine();
			if (isValidCarNames(input)) {
				this.carNames = input;
			}
			throw new IllegalArgumentException();
		}

		private boolean isValidCarNames(String string) {
			return string.matches("^[a-zA-Z][a-zA-Z0-9,]*");
		}
	}

	class RepeatNum {
		private int repeatNum;

		int getRepeatNum() {
			return repeatNum;
		}

		void initNum() {
			String input = Console.readLine();
			if (isValidNum(input)) {
				this.repeatNum = Integer.parseInt(input);
			}
		}

		private boolean isValidNum(String string) {
			return string.matches("^[1-9][0-9]*");
		}
	}
}
