package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
	int repeatNum;
	List<Car> carList;

	Race(List carList) {
		this.carList = carList;
		System.out.println("반복횟수 입력하세요 !");
		repeatNum = new NumberInitiator().getNumber();
		for (int i = 0; i < repeatNum; i++) {
			new Round().play();
		}
	}

	class Round {
		void play() {
			carList.forEach(car -> rollDice(car));
			System.out.println();
		}

		void rollDice(Car car) {
			if (4 <= rand()) {
				car.moveNext();
			}
			car.printPosition();
		}

		int rand() {
			return Randoms.pickNumberInRange(1, 9);
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