package racingcar;

import outpututils.Print;

import java.util.ArrayList;

public class GameManagement {
	private final int repetitionTime;
	static final private ArrayList<Car> participatedCars = new ArrayList<Car>();

	public GameManagement(String[] carInformation, int repetitionTime) {
		this.repetitionTime = repetitionTime;
		SetGamePlayer(carInformation);
		StartGame();
		Print.PrintWinner(new GameWinners(participatedCars, repetitionTime).GetGameWinners());
	}

	private void SetGamePlayer(String[] carInformation) {
		for (int i = 0; i < carInformation.length; i++) {
			participatedCars.add(new Car(carInformation[i]));
		}
	}

	private void StartGame() {
		System.out.println("\n실행결과");
		for (int turn = 0; turn < repetitionTime; turn++) {
			TurnManagement();
			Print.PrintResult(participatedCars);
		}
	}

	private void TurnManagement() {
		for (Car player : participatedCars) {
			player.StopOrGo();
		}
	}


}
