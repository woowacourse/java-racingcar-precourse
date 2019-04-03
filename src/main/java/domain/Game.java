package domain;

import java.util.Scanner;

public class Game {

	private String[] car_names;
	private Car[] cars;
	private int carCount;
	private int attemptCount;

	Scanner scanner = new Scanner(System.in);

	public void runPrompt() {
		inputCarName();
		numOfAttempts();
		System.out.println("실행 결과\n");
		for (int i = 1; i <= attemptCount; i++) {
			System.out.println(i + " 라운드");
			playGame();
			System.out.println();
		}
		printWinner();
		scanner.close();
	}

	public void inputCarName() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			String value = scanner.nextLine();
			car_names = value.split(",");
			carCount = car_names.length;
			cars = new Car[carCount];
			if (isnotValidName()) {
				continue;
			}
			for (int i = 0; i < carCount; i++) {
				cars[i] = new Car(car_names[i]);
			}
			return;
		}
	}

	private boolean isnotValidName() {
		// TODO
		return false;
	}

	private void numOfAttempts() {
		// TODO

	}

	private void playGame() {
		// TODO

	}

	private void printWinner() {
		// TODO

	}
}
