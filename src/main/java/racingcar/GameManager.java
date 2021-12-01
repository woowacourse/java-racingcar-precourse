package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;

public class GameManager {
	public InputManager inputManager;
	public Car[] cars;

	public GameManager(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public void startGame() {
		inputManager.scanCarsList();
		inputManager.scanNumberOfMove();
		cars = new Car[inputManager.carsList.length];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(inputManager.carsList[i]);
		}
		for (int i = 0; i < inputManager.numberOfMove; i++) {
			playRound();
		}
		printWinner();
	}

	public void playRound() {
		for (int i = 0; i < cars.length; i++) {
			cars[i].addPosition(calculateMove());
		}
		printResult();
	}

	public int calculateMove() {
		int randomNumber = Randoms.pickNumberInRange(0, 9);
		if (randomNumber >= 4) {
			return 1;
		}
		return 0;
	}

	public void printResult() {
		System.out.println("실행결과");
		for (int i = 0; i < cars.length; i++) {
			System.out.print(cars[i].getName() + " : ");
			for (int j = 0; j < cars[i].getPosition(); j++) {
				System.out.print("-");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printWinner() {
		int[] position = new int[cars.length];
		ArrayList<String> winner = new ArrayList<>();
		for (int i = 0; i < position.length; i++) {
			position[i] = cars[i].getPosition();
		}
		Arrays.sort(position);
		System.out.print("최종 우승자 : ");
		for (int i = 0; i < position.length; i++) {
			if (cars[i].getPosition() == position[cars.length - 1]) {
				winner.add(cars[i].getName());
			}
		}
		if (winner.size() == 1) {
			System.out.print(winner.get(0));
		} else if (winner.size() != 1) {
			for (int i = 0; i < winner.size(); i++) {
				System.out.print(winner.get(i));
				if (i != winner.size() - 1) {
					System.out.print(", ");
				}
			}
		}
		System.out.println();
	}
}
