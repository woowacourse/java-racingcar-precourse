package seonggyu.domain;

import seonggyu.rounds.Rounds;
import seonggyu.input.Input;
import seonggyu.participants.Participants;
import seonggyu.participants.Winners;

public class GameManager {
	private Participants participants;
	private Rounds rounds;
	
	public void startGame() {
		enterInputs();
		doRacing();
		findWinners();
	}
	
	private void enterInputs() {
		this.participants = new Participants(Input.enterCarNames());
		this.rounds = new Rounds(Input.enterRounds());
	}

	private void doRacing() {
		System.out.println("\n실행결과");
		for(int i = 0; i < this.rounds.getRounds(); i++) {
			this.participants.goOrStay();
			this.participants.printNamesAndPositions();
		}
	}
	
	private void findWinners() {
		Winners winners;
		winners = this.participants.getWinners();
		winners.printWinners();
	}
}
