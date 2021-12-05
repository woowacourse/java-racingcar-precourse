package racingcar.game;

import java.util.List;

import racingcar.domain.Car;
import racingcar.messages.PrintResult;
import racingcar.messages.ResultMessages;
import racingcar.utils.input.CarNameInput;
import racingcar.utils.input.GameTimesInput;

public class RacingGame {
	private CarNameInput carNameInput;
	private GameTimesInput gameTimesInput;
	private RacingGameReferee racingGameReferee;
	private PrintResult printResult;
	private List<Car> cars;
	private int numOfIteration;

	public RacingGame() {
		carNameInput = new CarNameInput();
		gameTimesInput = new GameTimesInput();
		racingGameReferee = new RacingGameReferee();
		printResult = new PrintResult();
	}

	public void init() {
		cars = carNameInput.getCar();
		numOfIteration = gameTimesInput.getGameTimes();
	}

	public void gameStart() {
		System.out.println(ResultMessages.GAME_RESULT);
		for (int gameCount = 0; gameCount < numOfIteration; gameCount++) {
			racingGameReferee.race(cars);
			cars.stream()
				.forEach(car -> printResult.printGameResult(car));
			System.out.println();
		}
	}

	public void awards() {
		List<Car> gameWinners = racingGameReferee.getGameResult(cars);
		printResult.printWinner(gameWinners);
	}

}
