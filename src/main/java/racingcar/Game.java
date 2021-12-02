package racingcar;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private Vector<Car> cars;
	private int gameTurn;

	public Game() {
		cars = new Vector<Car>();
		gameTurn = 0;
	}

	public void playGame() {
		setCars();
		setGameTurn();

		for (int i = 0; i < gameTurn; i++) {

			for (int j = 0; j < cars.size(); j++) {
				cars.get(j).move();
			}

		}

		printWinner();
	}

	public void setCars() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();
		Vector<String> seperatedCarNames = separateCarNames(carNames);

		for (int i = 0; i < seperatedCarNames.size(); i++) {
			Car car = new Car(seperatedCarNames.get(i));
			cars.add(car);
		}

	}

	public Vector<String> separateCarNames(String carNames) {
		Vector<String> seperatedCarNames = new Vector<String>();
		int newCarNameStartIdx = 0;

		for (int i = 0; i < carNames.length(); i++) {

			if (carNames.charAt(i) == ',') {
				seperatedCarNames.add(carNames.substring(newCarNameStartIdx, i - 1));
				newCarNameStartIdx = i + 1;
			}

		}

		seperatedCarNames.add(carNames.substring(newCarNameStartIdx, carNames.length() - 1));
		return seperatedCarNames;
	}

	public void setGameTurn() {
		System.out.println("시도할 회수는 몇회인가요?");
		gameTurn = setGameTurnWithoutException();
	}

	public int setGameTurnWithoutException() {
	}

	public void printWinner() {
	}
}
