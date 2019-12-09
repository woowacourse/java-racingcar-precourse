package com.woowahan.racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Race extends AbstractRace {
	public Race(User user) {
		this.user = user;
	}

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
		System.out.println();
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
		ArrayList<Car> winners = getWinners();

		for (Car winner : winners) {
			System.out.print(winner.getName());

			boolean isLastIndex = winners.indexOf(winner) == winners.size() - 1;
			if (!isLastIndex) {
				System.out.print(", ");
			}
		}
		System.out.println("가 최종 우승했습니다.");
	}

	@Override
	public void start() {
		System.out.println();
		System.out.println("실행 결과");
		for (int i = 0; i < user.getRound(); i++) {
			tryDrives();
			printStatus();
		}

		printResult();
	}
}
