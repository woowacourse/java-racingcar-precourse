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
		separateCarNames(carNames);
	}

	public void separateCarNames(String carNames) {
	}

	public void setGameTurn() {
	}

	public void printWinner() {
	}
}
