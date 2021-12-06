package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Winner {
	private static final int FIRST_CAR = 0;
	private static final int MIN_CAR_POSITION = 0;
	private List<String> winners = new ArrayList<>();

	public Winner(String[] carNames, int[] carPositions) {
		int maxPosition = maxCarPosition(carPositions);
		for (int index = FIRST_CAR; index < carPositions.length; index++) {
			if (carPositions[index] == maxPosition) {
				winners.add(carNames[index]);
			}
		}
	}

	private int maxCarPosition(int[] carPositions) {
		int maxPosition = MIN_CAR_POSITION;
		for (int index = FIRST_CAR; index < carPositions.length; index++) {
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
