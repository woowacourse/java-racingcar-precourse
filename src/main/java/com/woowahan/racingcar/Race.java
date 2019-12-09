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
	protected void processRound() {

	}

	@Override
	protected void tryDrive(Car car) {

	}

	@Override
	protected void printStatus() {

	}

	@Override
	protected boolean isFinalRound() {
		return false;
	}

	@Override
	protected ArrayList<Car> getWinners() {
		return null;
	}

	@Override
	protected void printResult() {

	}

	@Override
	public void start() {

	}
}
