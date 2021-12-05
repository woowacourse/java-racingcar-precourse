package racingcar;

import java.util.ArrayList;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

/**
 * <h1>실제 레이싱 게임 로직</h1>
 *
 * @author yunki kim
 * @version 1.4
 * @since 2021-12-01(V1.0)
 */

public class RacingGame {

	public static final Integer CAR_NAME_MAX_LENGTH = 5;

	public static final String NUMBER_PATTERN = "^[0-9]*$";

	private final ArrayList<Car> cars;

	private int turns;

	private int farthestPosition;

	public RacingGame() {
		this(new ArrayList<>());
	}

	public RacingGame(ArrayList<Car> cars) {
		this.cars = cars;
		this.turns = 0;
		this.farthestPosition = 0;
	}

	private void inputRacingCarName() throws IllegalArgumentException {
		System.out.println(RacingGameMessage.INPUT_RACING_CAR_NAME);
		final String[] carNames = Console.readLine().split(",");
		for (final String carName : carNames) {
			if (carName.length() > CAR_NAME_MAX_LENGTH) {
				final String errorMessage = RacingGameMessage.getCarNameErrorMessage(carName);
				cars.clear();
				throw new IllegalArgumentException(errorMessage);
			}
			cars.add(new Car(carName));
		}
	}

	private void inputRacingTurns() throws IllegalArgumentException {
		System.out.println(RacingGameMessage.INPUT_RACING_TURNS);
		final String playerInputtedTurns = Console.readLine();
		if (!Pattern.matches(NUMBER_PATTERN, playerInputtedTurns)) {
			final String errorMessage = RacingGameMessage.INVALID_TURNS;
			throw new IllegalArgumentException(errorMessage);
		}
		turns = Integer.parseInt(playerInputtedTurns);
		System.out.print("\n");
	}

	private void inputRacingInformation() {
		while (true) {
			try {
				inputRacingCarName();
				break;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}

		while (true) {
			try {
				inputRacingTurns();
				break;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	private void printThisTurnResult() {
		cars.forEach(car -> {
			int carPosition = car.getPosition();
			final String carName = car.getName();

			farthestPosition = Math.max(farthestPosition, carPosition);

			RacingGameMessage.printCarPosition(carPosition, carName);
		});
		System.out.print("\n");
	}

	private void startNextTurn() {
		cars.forEach(Car::goForward);
		printThisTurnResult();
	}

	private void printWinnerList() {
		final String[] winners = cars.stream()
			.filter(car -> car.getPosition() == farthestPosition)
			.map(Car::getName)
			.toArray(String[]::new);
		final String winnerList = String.join(", ", winners);

		System.out.print(RacingGameMessage
			.getWinnerListMessage(winnerList));
	}

	public void startGame() {
		inputRacingInformation();
		System.out.println(RacingGameMessage.GAME_RESULT);
		while (turns-- > 0) {
			startNextTurn();
		}
		printWinnerList();
	}
}
