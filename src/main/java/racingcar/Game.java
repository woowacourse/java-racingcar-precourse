package racingcar;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	private static final int LIMIT_CAR_NAME_SIZE = 5;
	private static final int NO_NAME = 0;

	private static final String ASK_TO_GET_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String ASK_TO_GET_GAME_TURN = "시도할 회수는 몇회인가요?";

	private static final String GAME_TURN_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 한다.";

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

		Winner winner = new Winner(cars);
		winner.print();
	}

	private void setCars() {
		boolean reset = true;

		System.out.println(ASK_TO_GET_CAR_NAME);

		while (reset) {
			reset = false;
			cars.clear();
			String carNames = Console.readLine();
			String[] seperatedCarNames = carNames.split(",");
			CarNameException carNameException = new CarNameException(seperatedCarNames);

			if (!carNameException.canMakeCarsCompletely()) {
				reset = true;
			} else {
				makeCars(seperatedCarNames);
			}

		}

	}

	private void makeCars(String[] seperatedCarNames) {

		for (int i = 0; i < seperatedCarNames.length; i++) {
			cars.add(new Car(seperatedCarNames[i]));
		}

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

}
