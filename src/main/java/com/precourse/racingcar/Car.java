/*
 * Car.java                        1.1.0   2019-12-05
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

/**
 * 자동차 클래스입니다.
 *
 * @version 1.1.0            차가 전진할지 말지 정하는 기능 추가
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
		int randomNumber = MOVE_THRESHOLD; // randomNumber를 구하는 기능 이 들어갈 위치

		if (randomNumber >= MOVE_THRESHOLD) {
			move = true;
		}

		return move;
	}
}
