package racingcar;

import java.util.ArrayList;

public class RacingGameCarManager {

	private Car[] cars;

	protected void makeCarInstance(String[] carNameBucket) {
		cars = new Car[carNameBucket.length];
		for (int i = 0; i < carNameBucket.length; ++i) {
			cars[i] = new Car(carNameBucket[i]);
		}
	}

	protected void moveAllCars() {
		for (int i = 0; i < cars.length; ++i) {
			cars[i].moveCar();
		}
	}

	protected StringStringPair[] getAllCarsCurrentPositionData() {
		StringStringPair[] allCarsCurrentPositionData = new StringStringPair[cars.length];
		for (int i = 0; i < cars.length; ++i) {
			allCarsCurrentPositionData[i] = new StringStringPair(cars[i].getName(),
				cars[i].getCurrentPositionVisualization());
		}
		return allCarsCurrentPositionData;
	}

	private int getBestScore() {
		int bestScore = 0;
		for (int i = 0; i < cars.length; ++i) {
			if (cars[i].getPosition() > bestScore) {
				bestScore = cars[i].getPosition();
			}
		}
		return bestScore;
	}

	private ArrayList<Integer> getWinnersIndex() {
		int bestScore = getBestScore();
		ArrayList<Integer> winnersIndex = new ArrayList<>();
		for (int i = 0; i < cars.length; ++i) {
			if (bestScore == cars[i].getPosition()) {
				winnersIndex.add(i);
			}
		}
		return winnersIndex;
	}

	protected String[] getWinnerNameBucket() {
		ArrayList<Integer> winnerIndex = getWinnersIndex();
		String[] winnerNameBucket = new String[winnerIndex.size()];
		for (int i = 0; i < winnerIndex.size(); ++i) {
			winnerNameBucket[i] = cars[i].getName();
		}
		return winnerNameBucket;
	}
}
