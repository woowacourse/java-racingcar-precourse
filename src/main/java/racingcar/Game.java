package racingcar;

import java.util.Vector;

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
	}

	public void setGameTurn() {
	}

	public void printWinner() {
	}
}
