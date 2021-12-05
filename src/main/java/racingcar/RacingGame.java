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

	/** 사용자가 입력 가능한 차량이름의 최대 길이 */
	public static final Integer CAR_NAME_MAX_LENGTH = 5;

	/** 사용자가 입력한 턴 수 유효여부를 체크하는 정규식 */
	public static final String NUMBER_PATTERN = "^[0-9]*$";

	/** 레이싱 경주에 사용할 자동차 리스트 */
	private final ArrayList<Car> cars;

	/** 레이싱 턴 갯수 */
	private int turns;

	/** 레이싱 게임에서 가장 많은 거리를 간 차량의 위치 */
	private int farthestPosition;

	/**
	 * RacingGame 생성자
	 *
	 * RacingGame 인스턴스 생성시 Car의 ArrayList를 인자로 넘기지 않았으면
	 * 생성해 인자로 넘긴다
	 */
	public RacingGame() {
		this(new ArrayList<>());
	}

	/**
	 * RacingGame 생성자
	 *
	 * @param cars 자동차 리스트
	 */
	public RacingGame(ArrayList<Car> cars) {
		this.cars = cars;
		this.turns = 0;
		this.farthestPosition = 0;
	}

	/** 자동차 이름을 유저로부터 입력받는다 */
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

	/** 레이싱 게임 횟수를 유저로부터 입려받는다 */
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

	/** 레이싱 게임의 정보를 유저로부터 입력받는다 */
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

	/** 이번 턴의 진행 결과를 출력한다 */
	private void printThisTurnResult() {
		cars.forEach(car -> {
			int carPosition = car.getPosition();
			final String carName = car.getName();

			farthestPosition = Math.max(farthestPosition, carPosition);

			RacingGameMessage.printCarPosition(carPosition, carName);
		});
		System.out.print("\n");
	}

	/** 다음 턴을 시작한다 */
	private void startNextTurn() {
		cars.forEach(Car::goForward);
		printThisTurnResult();
	}

	/** 우승자를 찾아 출력한다 */
	private void printWinnerList() {
		final String[] winners = cars.stream()
			.filter(car -> car.getPosition() == farthestPosition)
			.map(Car::getName)
			.toArray(String[]::new);
		final String winnerList = String.join(", ", winners);

		System.out.print(RacingGameMessage
			.getWinnerListMessage(winnerList));
	}

	/** 이 메서드를 호출하면 레이싱 게임을 시작한다 */
	public void startGame() {
		inputRacingInformation();
		System.out.println(RacingGameMessage.GAME_RESULT);
		while (turns-- > 0) {
			startNextTurn();
		}
		printWinnerList();
	}
}
