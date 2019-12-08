/*
 * Race.java                      2.5.0    2019-12-08
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
 * 레이스를 시작, 진행하고 우승자를 판단, 출력하는 기능이 있습니다.
 *
 * @version 2.5.0            레이스 우승자를 반환하는 기능 추가
 * @date 2019-12-08
 * @author HyungjuAn
 */
public class Race {
	private static final String RACE_START = "경주 시작!";
	private static final String WINNER_PRINTING = "가 최종 우승했습니다!";
	private static final char COMMA = ',';
	private static final char SPACE = ' ';
	private static final int ONE = 1;

	private ArrayList<Car> carArrayList;
	private int raceCount;

	public Race(ArrayList<Car> carArrayList, int raceCount) {
		this.carArrayList = carArrayList;
		this.raceCount = raceCount;
	}

	public void start() {
		printRaceStart();
		runRace();
	}

	private void printRaceStart() {
		System.out.println(RACE_START);
	}

	private void runRace() {
		for (int i = 0; i < raceCount; i++) {
			for (Car nextCar : carArrayList) {
				nextCar.run();
			}
		}
	}

	public void printWinner() {
		StringBuilder builder = new StringBuilder();
		ArrayList<Car> winnerArrayList = getWinner();
		int winnerCount = winnerArrayList.size();

		for (int i = 0; i < winnerCount; i++) {
			builder.append(winnerArrayList.get(i).getName());
			if (i != winnerCount - ONE) {
				builder.append(COMMA).append(SPACE);
			}
		}
		builder.append(WINNER_PRINTING);

		System.out.println(builder.toString());
	}

	private ArrayList<Car> getWinner() {
		ArrayList<Car> winnerArrayList = new ArrayList<>(); // 우승자를 찾는 메소드 필요

		return winnerArrayList;
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
