package racingcar;

import java.util.ArrayList;

public class GameWinners {
	final private ArrayList<String> winners = new ArrayList<String>();
	private int victoryScore = 0;

	public ArrayList<String> GetGameWinners() {
		return winners;
	}

	public GameWinners(ArrayList<Car> participatedCars, int repetitionTime) {
		FindVictoryScore(participatedCars);
		FindWinner(participatedCars);
	}

	private void FindWinner(ArrayList<Car> participatedCars) {
		for (Car player : participatedCars) {
			CheckWinner(player);
		}
	}

	private void CheckWinner(Car player) {
		if (player.GetPosition() == victoryScore) {
			winners.add((player.GetName()));
		}
	}

	private void FindVictoryScore(ArrayList<Car> participatedCars) {
		for (Car player : participatedCars) {
			CheckVictoryScore(player.GetPosition());
		}
	}

	private void CheckVictoryScore(int playerScore) {
		if (playerScore > victoryScore) {
			victoryScore = playerScore;
		}
	}
}
