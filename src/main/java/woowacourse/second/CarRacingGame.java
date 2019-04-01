package woowacourse.second;

import java.util.Scanner;

import domain.Car;

public class CarRacingGame {
	
	Car [] cars;
	
	public void gameStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String input = sc.next();
		if (this.validInput(input)) {
			String [] carNames = input.split(",");
			this.settingCars(carNames, carNames.length);
		}
		sc.close();
	}
	
	private void settingCars(String [] carNames, int amount) {
		this.cars = new Car[amount];
		for (int i = 0; i < amount; i++) {
			this.cars[i] = new Car(carNames[i]);
		}
	}
	
	private boolean validInput(String input) {
		return input.matches("([a-zA-Z가-힣]{1,6},)*([a-zA-Z가-힣]{1,6})");
	}
}
