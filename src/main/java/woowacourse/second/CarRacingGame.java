package woowacourse.second;

import java.util.Scanner;

import domain.Car;

public class CarRacingGame {
	
	Car [] cars;
	
	public void gameStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = sc.next();
		if (!this.validInput(input)) {
			System.out.println("잘못된 입력값입니다. 다시 시도해주세요");
			sc.close();
			return;
		}
		System.out.println("시도할 회수는 몇회인가요?");
		int n = sc.nextInt();
		this.racing(n);
		sc.close();
	}

	private void racing(int n) {
		System.out.println("실행 결과");
		int maxMove = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < this.cars.length; j++) {
				Car car = cars[j];
				car.move();
				maxMove = Math.max(maxMove, car.getPosition());
				car.printStatus();				
			}
			System.out.println();
		}
		this.whoWinner(maxMove);
	}
	
	private void whoWinner(int maxMove) {
		String winnerNames = "";
		for (int i = 0; i < this.cars.length; i++) {
			Car car = cars[i];
			if (car.getPosition() == maxMove) {
				winnerNames += car.getName() + " ";
			}
		}
		String [] winners = winnerNames.split(" ");
		this.printWinners(winners);
	}
	
	private void printWinners(String [] winners) {
		int numWinner = winners.length;
		for (int i = 0; i < numWinner; i++) {
			System.out.print(winners[i]);
			if (i != numWinner-1) {
				System.out.print(",");
			}
		}
		System.out.println("가 최종 우승했습니다.");
	}
	
	private void settingCars(String [] carNames, int amount) {
		this.cars = new Car[amount];
		for (int i = 0; i < amount; i++) {
			this.cars[i] = new Car(carNames[i]);
		}
	}
	
	private boolean validInput(String input) {
		boolean valid = input.matches("([a-zA-Z가-힣]{1,6},)*([a-zA-Z가-힣]{1,6})");
		if (!valid) return false;
		String [] carNames = input.split(",");
		this.settingCars(carNames, carNames.length);
		return true;
	}
}
