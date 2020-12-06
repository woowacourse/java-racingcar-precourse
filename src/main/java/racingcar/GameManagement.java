package racingcar;

import outpututils.Print;

import java.util.ArrayList;

public class GameManagement {
	private final int repetitionTime;
	static final private ArrayList<Car> participatedCars = new ArrayList<Car>();

	public GameManagement(String[] carInformation, int repetitionTime) {
		this.repetitionTime = repetitionTime;
		setGamePlayer(carInformation);
		startGame();
		Print.printWinner(new GameWinners(participatedCars, repetitionTime).getGameWinners());
	}

	private void setGamePlayer(String[] carInformation) {
		for (int i = 0; i < carInformation.length; i++) {
			participatedCars.add(new Car(carInformation[i]));
		}
	}

	private void startGame() {
		System.out.println("\n실행결과");
		for (int turn = 0; turn < repetitionTime; turn++) {
			turnManagement();
			Print.printResult(participatedCars);
		}
	}

	private void turnManagement() {
		for (Car player : participatedCars) {
			player.stopOrGo();
		}
	}


}
