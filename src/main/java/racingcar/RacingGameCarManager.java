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
		ArrayList<Integer> winnersIndexBucket = new ArrayList<>();
		for (int i = 0; i < cars.length; ++i) {
			if (bestScore == cars[i].getPosition()) {
				winnersIndexBucket.add(i);
			}
		}
		return winnersIndexBucket;
	}

	protected String[] getWinnerNameBucket() {
		ArrayList<Integer> winnerIndexBucket = getWinnersIndex();
		String[] winnerNameBucket = new String[winnerIndexBucket.size()];
		for (int i = 0; i < winnerIndexBucket.size(); ++i) {
			int winnerIndex = winnerIndexBucket.get(i);
			winnerNameBucket[i] = cars[winnerIndex].getName();
		}
		return winnerNameBucket;
	}
}
