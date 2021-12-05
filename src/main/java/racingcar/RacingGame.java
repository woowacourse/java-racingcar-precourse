package racingcar;

import java.util.ArrayList;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

/**
 * <h1>레이싱 게임에 필요한 정보를 입력받고 레이싱 게임을 실행시킨다</h1>
 *
 * @author yunki kim
 * @version 2.0
 * @since 2021-12-01(V1.0)
 */

public class RacingGame {

	private static final Integer CAR_NAME_MAX_LENGTH = 5;

	private static final String NUMBER_PATTERN = "^[0-9]*$";

	private final Race race;

	public RacingGame() {
		this(new Race(new ArrayList<>()));
	}

	public RacingGame(Race race) {
		this.race = race;
	}

	private void inputRacingCarName() throws IllegalArgumentException {
		System.out.println(RacingGameMessage.INPUT_RACING_CAR_NAME);
		final String[] carNames = Console.readLine().split(",");
		for (final String carName : carNames) {
			if (carName.length() > CAR_NAME_MAX_LENGTH) {
				final String errorMessage = RacingGameMessage.getCarNameErrorMessage(carName);
				race.removeCarList();
				throw new IllegalArgumentException(errorMessage);
			}
			final Car newCar = new Car(carName, new RandomGenerator());
			race.addCar(newCar);
		}
	}

	private void inputRacingTurns() throws IllegalArgumentException {
		System.out.println(RacingGameMessage.INPUT_RACING_TURNS);
		final String playerInputtedTurns = Console.readLine();
		if (!Pattern.matches(NUMBER_PATTERN, playerInputtedTurns)) {
			final String errorMessage = RacingGameMessage.INVALID_TURNS;
			throw new IllegalArgumentException(errorMessage);
		}
		race.setTurns(Integer.parseInt(playerInputtedTurns));
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

	public void startRacingGame() {
		inputRacingInformation();
		race.startRace();
	}

}
