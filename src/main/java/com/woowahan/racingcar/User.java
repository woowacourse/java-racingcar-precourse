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
		String carString;
		String[] carArray;
		ArrayList<Car> carArrayList;

		carString = getLine();
		carArray = carString.split(",");

		carArrayList = new ArrayList<Car>();
		for (String item : carArray) {
			carArrayList.add(new Car(item));
		}

		this.cars = carArrayList;
	}

	@Override
	protected void inputRound() {

	}

	@Override
	public void input() {

	}
}
