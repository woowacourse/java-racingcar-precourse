/*
 * Car.java                        1.2.0   2019-12-05
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

/**
 * 자동차 클래스입니다.
 *
 * @version 1.2.0            0~9사이의 랜덤값을 구하는 기능 추가
 * @date 2019-12-05
 * @author HyungjuAn
 */
public class Car {
	private final String name;
	private final int ZERO = 0;
	private final int TEN = 10;
	private final int MOVE_THRESHOLD = 4;

	private int position = ZERO;

	public Car(String name) {
		this.name = name;
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
}
