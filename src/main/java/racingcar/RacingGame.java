package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {

	public User user = new User();
	public Integer playRound;
	public List<Car> cars = new ArrayList<>();

	public void startGame() {
		System.out.println(Constant.START_NAME_MESSAGE);
		makeCarList();
		System.out.println(Constant.START_NUMBER_MESSAGE);
		getPlayRound();
		runGame(playRound);
		printWinners();
	}

	public void getPlayRound() {
		while (true) {
			try {
				playRound = user.getGameNumber();
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void makeCarList() {
		while (true) {
			try {
				String[] carNames = user.getNames();
				for (String carName : carNames) {
					cars.add(new Car(carName));
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void runGame(int playRound) {
		System.out.println("\n" + Constant.RESULT_MESSAGE);
		for (int i = 0; i < playRound; i++) {
			moveCars();
			printCurrentResult();
		}
	}

	public void moveCars() {
		for (Car car : cars) {
			int randomNumber = generateRandomNumber();
			if (isMovable(randomNumber)) {
				car.moveOneStep();
			}
		}
	}

	public int generateRandomNumber() {
		return Randoms.pickNumberInRange(Constant.START_RANDOM_NUMBER, Constant.END_RANDOM_NUMBER);
	}

	public boolean isMovable(int randomNumber) {
		return randomNumber >= Constant.MINIMUM_MOVABLE_NUMBER;
	}

	public void printCurrentResult() {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			printStatus(car.getPosition());
		}
		System.out.println();
	}

	public void printStatus(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public int findMaxPosition(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			if (maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}
		return maxPosition;
	}

	public void printWinners() {
		System.out.print(Constant.WINNER_MESSAGE);
		List<String> winners = findWinners();
		if (winners.size() == 1) {
			printSingleWinner(winners);
			return;
		}
		printMultipleWinner(winners);
	}

	public void printSingleWinner(List<String> winners) {
		System.out.println(winners.get(0));
	}

	public void printMultipleWinner(List<String> winners) {
		for (int i = 0; i < winners.size() - 1; i++) {
			System.out.print(winners.get(i) + ", ");
		}
		System.out.println(winners.get(winners.size() - 1));
	}

	public List<String> findWinners() {
		List<String> winners = new ArrayList<>();
		int maxPosition = findMaxPosition(cars);
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}
}