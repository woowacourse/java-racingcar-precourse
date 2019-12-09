package com.woowahan.racingcar;

import java.util.ArrayList;

public abstract class AbstractRace {
	protected User user;
	int currentRound = 1;

	protected abstract int getRandomInteger(int min, int max);

	protected abstract void tryDrives();

	protected abstract void tryDrive(Car car);

	protected abstract void printStatus();

	protected abstract boolean isFinalRound();

	protected abstract ArrayList<Car> getWinners();

	protected abstract void printResult();

	public abstract void start();
}
