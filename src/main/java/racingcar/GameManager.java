package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
	public InputManager inputManager;
	public Car[] cars;
	public ArrayList<String> winner = new ArrayList<>();

	public GameManager() {
		InputManager inputManager = new InputManager();
		this.inputManager = inputManager;
	}

	public void startGame() {
		inputManager.scanCarsList();
		inputManager.scanNumberOfMove();
		saveCarsList();
		System.out.println("\n실행결과");
		for (int i = 0; i < inputManager.getNumberOfMove(); i++) {
			playRound();
		}
		calculateWinner();
		printWinner();
	}

	public void saveCarsList() {
		cars = new Car[inputManager.getCarsList().length];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(inputManager.carsList[i]);
		}
	}

	public void playRound() {
		for (Car car : cars) {
			car.addPosition(calculateMove());
		}
		printResult();
	}

	public int calculateMove() {
		int randomNumber = Randoms.pickNumberInRange(Constant.MINIMUM_RANDOM_NUMBER, Constant.MAXIMUM_RANDOM_NUMBER);
		if (randomNumber >= Constant.MOVE_NUMBER) {
			return 1;
		}
		return 0;
	}

	public void printResult() {
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
		int[] positionList = getWinnerPosition();
		for (Car car : cars) {
			if (car.getPosition() == positionList[cars.length - 1]) {
				winner.add(car.getName());
			}
		}
	}

	public int[] getWinnerPosition() {
		int[] positionList = new int[cars.length];
		for (int i = 0; i < positionList.length; i++) {
			positionList[i] = cars[i].getPosition();
		}
		Arrays.sort(positionList);
		return positionList;
	}
}
