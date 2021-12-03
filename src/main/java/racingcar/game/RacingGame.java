package racingcar.game;

import java.util.List;

import racingcar.Car;
import racingcar.utils.CarNameInput;
import racingcar.utils.GameTimesInput;

public class RacingGame {
	private CarNameInput carNameInput;
	private GameTimesInput gameTimesInput;
	private RacingGameReferee racingGameReferee;
	private List<Car> cars;
	private int numOfIteration;

	public RacingGame() {
		carNameInput = new CarNameInput();
		gameTimesInput = new GameTimesInput();
		racingGameReferee = new RacingGameReferee();
	}

	public void init() {
		cars = carNameInput.getCar();
		numOfIteration = gameTimesInput.getGameTimes();
	}

	public void gameStart() {
		for (int gameCount = 0; gameCount < numOfIteration; gameCount++) {
			racingGameReferee.race(cars);
		}
	}

	public void awards() {
		List<Car> gameResult = racingGameReferee.getGameResult(cars);
	}

}
