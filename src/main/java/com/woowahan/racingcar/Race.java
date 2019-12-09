package com.woowahan.racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Race extends AbstractRace {
	@Override
	protected int getRandomInteger(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	@Override
	protected void tryDrives() {
		for (Car car : user.cars) {
			tryDrive(car);
		}
		currentRound++;
	}

	@Override
	protected void tryDrive(Car car) {
		int randomZeroToNine;
		randomZeroToNine = getRandomInteger(0, 9);

		if (randomZeroToNine >= 4) {
			car.drive();
		}
	}

	@Override
	protected void printStatus() {
		for (Car car : user.cars) {
			System.out.print(car.getName() + " : ");

			for (int i = 0; i < car.getPosition(); i++) {
				System.out.print("-");
			}

			System.out.println();
		}
	}

	@Override
	protected boolean isFinalRound() {
		return currentRound > user.getRound();
	}

	@Override
	protected ArrayList<Car> getWinners() {
		int topPosition = 0;
		ArrayList<Car> winners = new ArrayList<Car>();

		for (Car car : user.cars) {
			int position = car.getPosition();
			if (position < topPosition) {
				continue;
			}
			if (position > topPosition) {
				topPosition = position;
				winners.clear();
			}
			winners.add(car);
		}
		return winners;
	}

	@Override
	protected void printResult() {

	}

	@Override
	public void start() {

	}
}
