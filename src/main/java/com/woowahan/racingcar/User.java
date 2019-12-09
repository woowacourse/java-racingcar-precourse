package com.woowahan.racingcar;

import java.util.ArrayList;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
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
