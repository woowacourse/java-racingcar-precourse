package com.woowahan.racingcar;

import java.util.ArrayList;

public class User extends AbstractUser {

	@Override
	public ArrayList<Car> getCars() {
		return cars;
	}

	@Override
	public int getRound() {
		return round;
	}

	@Override
	protected String getLine() {
		return null;
	}

	@Override
	protected void inputCars() {

	}

	@Override
	protected void inputRound() {

	}

	@Override
	public void input() {

	}
}
