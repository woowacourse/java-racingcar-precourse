/*
 * Car.java                        1.4.6   2019-12-09
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

/**
 * Car 클래스입니다.
 * 자동차 경주를 하기위한 기능들이 있습니다.
 *
 * @version 1.4.6            클래스를 Comparable을 상속하게 수정하고 compareTo 재정의
 * @date 2019-12-09
 * @author HyungjuAn
 */
public class Car implements Comparable<Car> {
	private static final char COLON = ':';
	private static final char BAR = '-';
	private static final char SPACE = ' ';
	private static final int ZERO = 0;
	private static final int TEN = 10;
	private static final int MOVE_THRESHOLD = 4;

	private final String name;
	private int position = ZERO;

	public Car(String name) {
		this.name = name;
	}

	public void run() {
		if (isMove()) {
			this.position++;
		}

		printCurrentPosition();
	}

	private boolean isMove() {
		boolean move = false;
		int randomNumber = getRandomNumber();

		if (randomNumber >= MOVE_THRESHOLD) {
			move = true;
		}

		return move;
	}

	private int getRandomNumber() {
		return (int)(Math.random() * TEN);
	}

	private void printCurrentPosition() {
		StringBuilder builder = new StringBuilder();

		builder.append(this.name).append(COLON).append(SPACE);
		for (int i = 0; i < this.position; i++) {
			builder.append(BAR);
		}

		System.out.println(builder);
	}

	@Override
	public int compareTo(Car that) {
		return that.getPosition() - this.getPosition();
	}

	@Override
	protected final void finalize() throws Throwable {
	}

	/**
	 * 이 차의 이름과 현재 포지션을 반환합니다.
	 * 다음은 이 설명의 일반적인 형태이나,
	 * 상세 형식은 정해지지 않았으며 향후 변경될 수 있다.
	 * <p>
	 * "Name: pobi, Position: 3"
	 *
	 * @return 클래스를 나타낼 수 있는 정보를 가진 문자열
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", Position: " + position;
	}

	/* Getter methods */
	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
