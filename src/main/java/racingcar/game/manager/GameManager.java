package racingcar.game.manager;

import java.util.ArrayList;
import java.util.List;

import racingcar.common.model.ResultContainer;
import racingcar.game.model.Cars;
import racingcar.game.model.TryNumber;
import racingcar.game.service.CarNameGenerator;
import racingcar.game.service.Result;
import racingcar.game.service.TryNumberGenerator;

public class GameManager {
	public static void run() {
		final Cars cars = CarNameGenerator.generateCars();
		final TryNumber tryNumber = TryNumberGenerator.generateTryNumber();
		final List<Result> result = playRacingGame(cars, tryNumber);

		ResultContainer.printRacingGameResult(result);
		ResultContainer.printWinners(getFinalResult(result, tryNumber));
	}

	private static List<Result> playRacingGame(final Cars cars, final TryNumber tryNumber) {
		List<Result> result = new ArrayList<>();

		for (int i = 0; i < tryNumber.getTryNumber(); i++) {
			attemptMove(cars);
			result.add(new Result(cars));
		}

		return result;
	}

	private static void attemptMove(final Cars cars) {
		cars.attemptMove();
	}

	private static Result getFinalResult(final List<Result> result, final TryNumber tryNumber) {
		return result.get(tryNumber.getTryNumber() - 1);
	}

}
