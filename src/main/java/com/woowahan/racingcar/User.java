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
		String roundString;
		roundString = getLine();

		this.round = Integer.parseInt(roundString);
	}

	@Override
	public void input() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		inputCars();

		System.out.println("시도할 회수는 몇회인가요?");
		inputRound();
	}
}
