package com.woowahan.racingcar;

import java.util.ArrayList;

public abstract class AbstractUser {
	public abstract ArrayList<Car> getCars();

	public abstract int getRound();

	protected abstract String getLine();

	protected abstract void inputCars();

	protected abstract void inputRound();

	public abstract void input();
}
