package racingcar;

import static utils.Message.*;

import java.util.ArrayList;
import java.util.List;

import utils.Converter;

public class Racing {
	private final List<Car> cars;

	public Racing(String[] carNames) {
		cars = new ArrayList<>();

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void start(int roundNumber) {
		System.out.println(RACING_START);

		for (int round = 1; round <= roundNumber; round += 1) {
			moveCars();
			printRoundResult();
		}
	}

	private void moveCars() {
		for (Car car : cars) {
			car.movdOrStop();
		}
	}

	private void printRoundResult() {
		for (Car car : cars) {
			String carName = car.getName();
			String movement = Converter.convertToPosition(car.getPosition());

			System.out.println(carName + " : " + movement);
		}
		System.out.println();//공백추가
	}

	public void printWinner() {
		String winnerString = getWinner().toString();
		
		//대괄호지우기
		String formattedWinner = winnerString.substring(1, winnerString.length() - 1);

		System.out.print(RACING_WINNER);
		System.out.println(formattedWinner);
	}

	private List<String> getWinner() {
		List<String> winner = new ArrayList<>();

		int winnerPosition = getWinnerPosition();

		for (Car car : cars) {
			if (car.getPosition() == winnerPosition) {
				winner.add(car.getName());
			}
		}

		return winner;
	}

	private int getWinnerPosition() {
		int maxPosition = 0;

		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}
}
