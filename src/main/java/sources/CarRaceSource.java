package sources;

import java.util.ArrayList;

import domain.Car;
import Utils.UtilityMethods;


public class CarRaceSource {
	public static void playGameByNumber(int count, Car cars[]) {
		for (int i = 0; i < count; i++) {
			goForwardRandomly(cars);
			printRoundResult(cars);
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

	private static void printRoundResult(Car cars[]) {
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

	public static ArrayList<String> judgeWinner(Car[] cars) {
		ArrayList<String> winners = new ArrayList<String>();
		int winningPosition = judgeWinningPosition(cars);
		for (Car car : cars) {
			if (car.getPosition() == winningPosition) {
				winners.add(car.getName());
			}

		}

		return winners;
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


	public static void printWinner(ArrayList<String> winners) {
		String winnerString = UtilityMethods.getListToString(winners);
		System.out.println("\n" + winnerString + "가 최종 우승했습니다");
	}

}