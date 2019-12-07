package seonggyu.domain;

import seonggyu.cars.Cars;
import seonggyu.cars.Winners;
import seonggyu.rounds.Rounds;
import seonggyu.input.Input;

public class GameManager {
	public void startGame() {
		Cars cars = new Cars(Input.enterCarNames());
		Rounds rounds = new Rounds(Input.enterRounds());
		
		doRacing(cars, rounds);
		findWinners(cars);
	}
	
	private void doRacing(Cars cars, Rounds rounds) {
		System.out.println("\n실행결과");
		for(int i = 0; i < rounds.getRounds(); i++) {
			cars.goOrStay();
			cars.printNamesAndPositions();
		}
	}
	
	private void findWinners(Cars cars) {
		Winners winners;
		winners = cars.getWinners();
		winners.printWinners();
	}
}
