package racingcar;

import java.util.Vector;

import camp.nextstep.edu.missionutils.Console;

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
		boolean reset = true;

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

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

	public boolean makeCarsCompletely(Vector<String> seperatedCarNames) {

		for (int i = 0; i < seperatedCarNames.size(); i++) {

			if (!carNameException(seperatedCarNames.get(i))) {
				return false;
			}

			Car car = new Car(seperatedCarNames.get(i));
			cars.add(car);
		}

		return true;
	}

	public boolean carNameException(String carName) {

		try {

			if (carName.length() > 5) {
				throw new IllegalArgumentException();
			}

		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
			return false;
		}

		return true;
	}

	public Vector<String> separateCarNames(String carNames) {
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

	public void setGameTurn() {
		System.out.println("시도할 회수는 몇회인가요?");
		gameTurn = setGameTurnWithoutException();
	}

	public int setGameTurnWithoutException() {

		while (true) {
			try {
				String strGameTurn = Console.readLine();
				int intGameTurn = Integer.parseInt(strGameTurn);
				return intGameTurn;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
			}
		}

	}

	public void printWinner() {
		Vector<String> winnerNames = getWinnerNames();
		
		System.out.print("최종 우승자 : ");

		for (int i = 0; i < winnerNames.size() - 1; i++) {
			System.out.print(winnerNames.get(i) + ", ");
		}

		System.out.println(winnerNames.get(winnerNames.size() - 1));
	}

	public Vector<String> getWinnerNames() {
		Vector<String> winnerNames = new Vector<String>();
		int winnerPosition = getWinnerPosition();

		for (int i = 0; i < cars.size(); i++) {

			if (cars.get(i).getPosition() == winnerPosition) {
				winnerNames.add(cars.get(i).getName());
			}

		}

		return winnerNames;
	}

	public int getWinnerPosition() {
		int winnerPosition = 0;

		for (int i = 0; i < cars.size(); i++) {

			if (winnerPosition < cars.get(i).getPosition()) {
				winnerPosition = cars.get(i).getPosition();
			}

		}

		return winnerPosition;
	}
}
