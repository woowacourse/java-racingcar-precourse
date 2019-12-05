/*
 * Car.java                        1.4.1   2019-12-05
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

/**
 * 자동차 클래스입니다.
 *
 * @version 1.4.1            상수를 표시하기 위해 final -> static final로 수정
 * @date 2019-12-05
 * @author HyungjuAn
 */
public class Car {
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

	public void runRace() {
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
}
