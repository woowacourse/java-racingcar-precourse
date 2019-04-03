package domain;

import java.util.Scanner;

public class Game {

	private String[] car_names;
	private Car[] cars;
	private int carCount;
	private int attemptCount;
	private int max = 0;

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
			if (isnotValidName()) {
				continue;
			}
			inputCar();
			return;
		}
	}

	public void inputCar() {
		cars = new Car[carCount];
		for (int i = 0; i < carCount; i++) {
			cars[i] = new Car(car_names[i]);
		}
	}

	public boolean isnotValidName() {
		for (int i = 0; i < carCount; i++) {
			if (car_names[i].trim().length() == 0) {
				System.out.println("이름은 1글자 이상이어야 합니다.");
				return true;
			}
			if (car_names[i].length() > 5) {
				System.out.println("이름은 5자 이하만 가능합니다.");
				return true;
			}
		}
		return false;
	}

	public void numOfAttempts() {
		while (true) {
			System.out.println("시도할 횟수를 입력하세요.");
			String userinput = scanner.next();
			if (isnotNumber(userinput)) {
				continue;
			}
			attemptCount = Integer.parseInt(userinput);
			return;
		}
	}

	public boolean isnotNumber(String userinput) {
		try {
			Integer.parseInt(userinput);
			return false;
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요.");
			return true;
		}
	}

	public void playGame() {
		for (int i = 0; i < carCount; i++) {
			cars[i].oneRound();
		}
	}

	public int getMaxPosition() {
		for (int i = 0; i < carCount; i++) {
			if (cars[i].getPosition() > max) {
				max = cars[i].getPosition();
			}
		}
		return max;
	}

	public void printWinner() {
		max = getMaxPosition();
		String winner = "";
		for (int i = 0; i < carCount; i++) {
			if (cars[i].getPosition() == max) {
				winner += ", " + cars[i].getName();
			}
		}
		System.out.println(winner.substring(2) + "가 최종 우승했습니다.");
	}
}
