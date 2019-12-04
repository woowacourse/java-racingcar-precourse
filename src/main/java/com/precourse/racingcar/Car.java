/*
 * Car.java                        1.0.0   2019-12-04
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

/**
 * 자동차 클래스입니다.
 *
 * @version 1.0.0
 * @date 2019-12-04
 * @author HyungjuAn
 */
public class Car {
	private final String name;
	private final int ZERO = 0;

	private int position;

	public Car(String name) {
		this.name = name;
		position = ZERO;
	}
}
