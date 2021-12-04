package racingcar;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private static final int LIMIT_CAR_NAME_SIZE = 5;

	private static final String ASK_TO_GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ASK_TO_GET_GAME_TURN = "시도할 회수는 몇회인가요?";

	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE_1 = "[ERROR] 자동차 이름은 ";
	private static final String CAR_NAME_LENGTH_ERROR_MESSAGE_2 = "자 이하만 가능하다.";

	private static final String GAME_TURN_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

	private static final String FINAL_WINNER = "최종 우승자 : ";

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

			System.out.println();

		}

		printWinner();
	}

	private void setCars() {
		boolean reset = true;

		System.out.println(ASK_TO_GET_CAR_NAME);

		while (reset) {
			reset = false;
			cars.clear();
			String carNames = Console.readLine();
			Vector<String> seperatedCarNames = separateCarNames(carNames);

			if (!makeCarsCompletely(seperatedCarNames)) {
				reset = true;
			}
		}

	}

	private boolean makeCarsCompletely(Vector<String> seperatedCarNames) {

		for (int i = 0; i < seperatedCarNames.size(); i++) {

			if (!carNameException(seperatedCarNames.get(i))) {
				return false;
			}

			Car car = new Car(seperatedCarNames.get(i));
			cars.add(car);
		}

		return true;
	}

	private boolean carNameException(String carName) {

		try {

			if (carName.length() > LIMIT_CAR_NAME_SIZE) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println(CAR_NAME_LENGTH_ERROR_MESSAGE_1 + LIMIT_CAR_NAME_SIZE + CAR_NAME_LENGTH_ERROR_MESSAGE_2);
			return false;
		}

		return true;
	}

	private Vector<String> separateCarNames(String carNames) {
		Vector<String> seperatedCarNames = new Vector<String>();
		int newCarNameStartIdx = 0;

		for (int i = 0; i < carNames.length(); i++) {

			if (carNames.charAt(i) == ',') {
				seperatedCarNames.add(carNames.substring(newCarNameStartIdx, i));
				newCarNameStartIdx = i + 1;
			}

		}

		seperatedCarNames.add(carNames.substring(newCarNameStartIdx, carNames.length()));
		return seperatedCarNames;
	}

	private void setGameTurn() {
		System.out.println(ASK_TO_GET_GAME_TURN);
		gameTurn = setGameTurnWithoutException();
	}

	private int setGameTurnWithoutException() {
		while (true) {
			try {
				String strGameTurn = Console.readLine();
				int intGameTurn = Integer.parseInt(strGameTurn);
				return intGameTurn;
			} catch (IllegalArgumentException e) {
				System.out.println(GAME_TURN_ERROR_MESSAGE);
			}
		}

	}

	private void printWinner() {
		Vector<String> winnerNames = getWinnerNames();

		System.out.print(FINAL_WINNER);

		for (int i = 0; i < winnerNames.size() - 1; i++) {
			System.out.print(winnerNames.get(i) + ", ");
		}

		System.out.println(winnerNames.get(winnerNames.size() - 1));
	}

	private Vector<String> getWinnerNames() {
		Vector<String> winnerNames = new Vector<String>();
		int winnerPosition = getWinnerPosition();

		for (int i = 0; i < cars.size(); i++) {

			cars.get(i).insertNameIfIAmWinner(winnerPosition, winnerNames);

		}

		return winnerNames;
	}

	private int getWinnerPosition() {
		int winnerPosition = 0;

		for (int i = 0; i < cars.size(); i++) {

			winnerPosition = cars.get(i).judgeWhoIsGoingAhead(winnerPosition);

		}

		return winnerPosition;
	}
}
