package racingcar.game;

import java.util.List;

import racingcar.Car;
import racingcar.utils.CarNameInput;
import racingcar.utils.GameTimesInput;

public class RacingGame {
	private CarNameInput carNameInput;
	private GameTimesInput gameTimesInput;
	private List<Car> cars;
	private int numOfIteration;

	public RacingGame() {
		carNameInput = new CarNameInput();
		gameTimesInput = new GameTimesInput();
	}

	public void init() {
		cars = carNameInput.getCar();
		numOfIteration = gameTimesInput.getGameTimes();
	}

	public void gameStart(){

	}
}
