package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

public class GameManager {
	private InputManager inputManager;
	private Car[] cars;
	private ArrayList<String> winner = new ArrayList<>();

	public GameManager() {
		this.inputManager = new InputManager();
	}

	public void startGame() {
		inputManager.scanCarsList();
		inputManager.scanNumberOfMove();
		saveCarsList();
		printExecutionResult();
		calculateWinner();
		printWinner();
	}

	public void saveCarsList() {
		cars = new Car[inputManager.getCarsList().length];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(inputManager.getCarsList()[i]);
		}
	}

	public void printExecutionResult() {
		System.out.println();
		System.out.println("실행결과");
		for (int i = 0; i < inputManager.getNumberOfMove(); i++) {
			playRound();
		}
	}

	public void playRound() {
		for (Car car : cars) {
			car.calculateMove();
		}
		printCarMoveResult();
	}

	public void printCarMoveResult() {
		for (Car car : cars) {
			System.out.print(car.getName() + " : ");
			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printWinner() {
		System.out.print("최종 우승자 : ");
		if (winner.size() == 1) {
			System.out.print(winner.get(0));
			return;
		}
		for (int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i));
			if (i != winner.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public void calculateWinner() {
		int[] positionList = calculateWinnerPosition();
		for (Car car : cars) {
			if (car.getPosition() == positionList[cars.length - 1]) {
				winner.add(car.getName());
			}
		}
	}

	public int[] calculateWinnerPosition() {
		int[] positionList = new int[cars.length];
		for (int i = 0; i < positionList.length; i++) {
			positionList[i] = cars[i].getPosition();
		}
		Arrays.sort(positionList);
		return positionList;
	}
}
