package racingcar;

import java.util.Vector;

public class Winner {
	private static final String FINAL_WINNER = "최종 우승자 : ";

	private Vector<Car> cars;

	public Winner(Vector<Car> cars) {
		this.cars = cars;
	}

	public void print() {
		Vector<String> winnerNames = getWinnerList();

		System.out.print(FINAL_WINNER);

		for (int i = 0; i < winnerNames.size() - 1; i++) {
			System.out.print(winnerNames.get(i) + ", ");
		}

		System.out.println(winnerNames.get(winnerNames.size() - 1));
	}

	private Vector<String> getWinnerList() {
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
