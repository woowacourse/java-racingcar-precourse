package model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
	private List<String> winners = new ArrayList<>();

	public Winner(String[] carNames, int[] carPositions) {
		int maxPosition = maxCarPosition(carPositions);
		for (int index = 0; index < carPositions.length; index++) {
			if (carPositions[index] == maxPosition) {
				winners.add(carNames[index]);
			}
		}
	}

	private int maxCarPosition(int[] carPositions) {
		int maxPosition = 0;
		for (int index = 0; index < carPositions.length; index++) {
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
