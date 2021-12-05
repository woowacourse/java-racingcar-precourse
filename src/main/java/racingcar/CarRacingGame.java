package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CarRacingGame {
	private static final InputValidator inputValidator = new InputValidator();
	private int roundNumber;
	private Cars cars;

	public void play() {
		createCars();
		inputRoundNumber();
		System.out.println("실행 결과");
		for (int i = 0; i < roundNumber; i++) {
			cars.move();
			cars.printAll();
			System.out.println();
		}
		cars.findWinner();
	}

	private void createCars() {
		String[] carNames = inputNames();
		cars = new Cars(carNames);
	}

	private String[] inputNames() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String[] names = Console.readLine().split(",");
			if (inputValidator.isValidNamesInput(names)) {
				return names;
			}
		}
	}

	private void inputRoundNumber() {
		while (true) {
			System.out.println("시도할 회수는 몇회인가요?");
			String roundNumber = Console.readLine();
			if (inputValidator.isValidNumberInput(roundNumber)) {
				this.roundNumber = Integer.parseInt(roundNumber);
				return;
			}
		}
	}

}
