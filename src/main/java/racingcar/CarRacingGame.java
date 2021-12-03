package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;

public class CarRacingGame {
	private InputValidator inputValidator = new InputValidator();
	private int roundNumber;

	public void createCars() {
		String[] carNames = inputNames();
		Cars cars = new Cars(carNames);
	}

	public String[] inputNames() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String[] names = Console.readLine().split(",");
			if (isNamesInputException(names) == false) {
				return names;
			}
		}
	}

	public boolean isNamesInputException(String[] names) {
		return inputValidator.isNamesLessThanSix(names) == false
			|| inputValidator.isNamesDistinct(names) == false;
	}

	public void inputRoundNumber() {
		while (true) {
			System.out.println("시도할 회수는 몇회인가요?");
			String roundNumber = Console.readLine();
			if (isRoundNumberInputException(roundNumber) == false) {
				this.roundNumber = Integer.parseInt(roundNumber);
				return;
			}
		}
	}

	public boolean isRoundNumberInputException(String roundNumber) {
		return inputValidator.isNumber(roundNumber) == false
			|| inputValidator.isNumberMoreThanMin(roundNumber) == false;
	}

}
