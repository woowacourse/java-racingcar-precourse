/*
 * Race.java                      2.2.1    2019-12-08
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

import java.util.ArrayList;

/**
 * Race 클래스입니다.
 * 경주를 위한 자동차들과 레이싱 횟수를 가지고 있습니다.
 *
 * @version 2.2.1            Car class에서 변경된 메소드명 적용
 * @date 2019-12-08
 * @author HyungjuAn
 */
public class Race {
	private static final String RACE_START = "경주 시작!";

	private ArrayList<Car> carArrayList;
	private int raceCount;

	public Race(ArrayList<Car> carArrayList, int raceCount) {
		this.carArrayList = carArrayList;
		this.raceCount = raceCount;
	}

	public void start() {
		printRaceStart();
		for (int i = 0; i < raceCount; i++) {
			for (Car nextCar : carArrayList) {
				nextCar.run();
			}
		}

		// 최종 우승자를 판단하는 기능
		// 최종 우승자를 출력하는 기능
	}

	private void printRaceStart() {
		System.out.println(RACE_START);
	}

	@Override
	protected final void finalize() throws Throwable {
	}

	/**
	 * 이 경주의 자동차 리스트와 레이스 횟수를 알려줍니다.
	 * 다음은 이 설명의 일반적인 형태이나,
	 * 상세 형식은 정해지지 않았으며 향후 변경될 수 있다.
	 * <p>
	 * "[pobi, hj]로 3회 경주"
	 *
	 * @return 클래스를 나타낼 수 있는 정보를 가진 문자열
	 */
	@Override
	public String toString() {
		return carArrayList.toString() + "로 " + raceCount + "회 경주";
	}

	/* Getter Methods */
	public ArrayList<Car> getCarArrayList() {
		return carArrayList;
	}

	public int getRaceCount() {
		return raceCount;
	}

	/* Setter Methods */
	public void setCarArrayList(ArrayList<Car> carArrayList) {
		this.carArrayList = carArrayList;
	}

	public void setRaceCount(int raceCount) {
		this.raceCount = raceCount;
	}
}
