import java.util.ArrayList;

import domain.Car;

public class UtilityMethods {
	public static Car[] sliceString(String target) {
		String[] slicedString = target.split(",");
		Car[] cars = new Car[slicedString.length];

		for (int i = 0; i < slicedString.length; i++) {
			cars[i] = new Car(slicedString[i]);
		}

		return cars;
	}

	public static void playGameByNumber(int count, Car cars[]) {
		for (int i = 0; i < count; i++) {
			goForwardRandomly(cars);
			printGameResult(cars);
		}

	}

	private static void goForwardRandomly(Car[] cars) {
		double randomNumber = 0;

		for (Car car : cars) {
			randomNumber = Math.random();
			randomNumber = (int) (randomNumber * 10);
			if (randomNumber >= 4) {
				car.goForward();
			}
		}

	}

	private static void printGameResult(Car cars[]) {
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

	public static void printWinner(Car[] cars) {
		int position = 0;
		String winnerString = "";
		ArrayList<String> winners;

		position = judgeWinningPosition(cars);
		winners = judgeWinner(position, cars);
		winnerString = getWinnerstoString(winners);
		System.out.println("\n" + winnerString + "가 최종 우승했습니다");
	}

	private static int judgeWinningPosition(Car[] cars) {
		int position = 0;

		for (Car car : cars) {
			if (car.getPosition() > position) {
				position = car.getPosition();
			}

		}

		return position;
	}

	private static ArrayList<String> judgeWinner(int winningPosition, Car[] cars) {
		ArrayList<String> winners = new ArrayList<String>();
		for (Car car : cars) {
			if (car.getPosition() == winningPosition) {
				winners.add(car.getName());
			}

		}

		return winners;
	}

	private static String getWinnerstoString(ArrayList<String> winners) {
		int winnerCount = 0;
		String winnerString = "";

		for (String winner : winners) {
			if (winnerCount == 0) {
				winnerString = winner;
			} else if (winnerCount > 0) {
				winnerString = winnerString + ", " + winner;
			}
			winnerCount++;
		}

		return winnerString;
	}
}
