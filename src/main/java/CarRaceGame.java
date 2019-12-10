import domain.Car;

import java.util.ArrayList;

public class CarRaceGame {
	public void playGameByNumber(int count, Car cars[]) {
		for (int i = 0; i < count; i++) {
			goForwardRandomly(cars);
			printGameResult(cars);
		}

	}

	private void goForwardRandomly(Car[] cars) {
		double randomNumber = 0;

		for (Car car : cars) {
			randomNumber = Math.random();
			randomNumber = (int) (randomNumber * 10);
			if (randomNumber >= 4) {
				car.goForward();
			}
		}

	}

	private void printGameResult(Car cars[]) {
		String gameResult = "";

		System.out.println("");
		for (Car car : cars) {
			String progress = "";
			for (int i = 0; i < car.getPosition(); i++) {
				progress += '-';
			}

			gameResult = car.getName() + " : " + progress;
			System.out.println(gameResult);
		}

	}

	public ArrayList<String> judgeWinner(Car[] cars) {
		ArrayList<String> winners = new ArrayList<String>();
		int winningPosition = judgeWinningPosition(cars);
		for (Car car : cars) {
			if (car.getPosition() == winningPosition) {
				winners.add(car.getName());
			}

		}

		return winners;
	}

	private int judgeWinningPosition(Car[] cars) {
		int position = 0;

		for (Car car : cars) {
			if (car.getPosition() > position) {
				position = car.getPosition();
			}

		}

		return position;
	}


	public void printWinner(ArrayList<String> winners) {
		String winnerString = UtilityMethods.getListToString(winners);
		System.out.println("\n" + winnerString + "가 최종 우승했습니다");
	}

	public static void main(String[] args) {
		
	}
}
