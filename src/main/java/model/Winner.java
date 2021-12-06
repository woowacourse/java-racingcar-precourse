package model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private static final int FIRST_CAR_LOCATION = 0;
	private static final int MIN_CAR_POSITION = 0;
	private List<String> winners = new ArrayList<>();

	public Winner(String[] carNames, int[] carPositions) {
		int maxPosition = maxCarPosition(carPositions);
		int lastCarPostion = carPositions.length - 1;
		for (int index = FIRST_CAR_LOCATION; index <= lastCarPostion; index++) {
			int candidateCarPosition = carPositions[index];
			String candidateCarName = carNames[index];
			compareCandidateWithWinner(candidateCarName, candidateCarPosition, maxPosition);
		}
	}

	private void compareCandidateWithWinner(String candidateCarName, int candidateCarPostion, int maxPosition) {
		if (candidateCarPostion == maxPosition) {
			winners.add(candidateCarName);
		}
	}

	private int maxCarPosition(int[] carPositions) {
		int maxPosition = MIN_CAR_POSITION;
		for (int index = FIRST_CAR_LOCATION; index < carPositions.length; index++) {
			if (carPositions[index] > maxPosition) {
				maxPosition = carPositions[index];
			}
		}
		return maxPosition;
	}

	public List<String> getWinners() {
		return winners;
	}
}
