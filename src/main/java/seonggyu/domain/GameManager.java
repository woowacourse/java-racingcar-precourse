package seonggyu.domain;

import seonggyu.cars.Cars;
import seonggyu.rounds.Rounds;
import seonggyu.cars.Winners;
import seonggyu.input.Input;

public class GameManager {
	private Cars cars;
	private Rounds rounds;
	
	public void startGame() {
		enterInputs();
		doRacing();
		findWinners();
	}
	
	private void enterInputs() {
		this.cars = new Cars(Input.enterCarNames());
		this.rounds = new Rounds(Input.enterRounds());
	}

	private void doRacing() {
		System.out.println("\n실행결과");
		for(int i = 0; i < this.rounds.getRounds(); i++) {
			this.cars.goOrStay();
			this.cars.printNamesAndPositions();
		}
	}
	
	private void findWinners() {
		Winners winners;
		winners = this.cars.getWinners();
		winners.printWinners();
	}
}
