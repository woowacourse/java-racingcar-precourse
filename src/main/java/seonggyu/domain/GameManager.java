package seonggyu.domain;

import seonggyu.cars.Cars;
import seonggyu.cars.Winners;
import seonggyu.input.Input;

import java.util.List;

public class GameManager {
	public void playGame() {
		List<String> carNames = Input.enterCarNames();
		Cars cars = new Cars(carNames);
		int rounds = Input.enterRounds();
		
		doRacing(cars, rounds);
		
		findWinners(cars);
	}
	
	private void doRacing(Cars cars, int rounds) {
		System.out.println("\n실행결과");
		for(int i = 0; i < rounds; i++) {
			cars.decidePositions();
			cars.printNamesAndPositions();
			System.out.println();
		}
	}
	
	private void findWinners(Cars cars) {
		Winners winners;
		winners = cars.getWinners();
		winners.printWinners();
	}
}
