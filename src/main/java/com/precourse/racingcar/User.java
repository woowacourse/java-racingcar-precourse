/*
 * User.java                       1.2.0   2019-12-05
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

import java.util.ArrayList;

/**
 * User 클래스입니다.
 * 사용자에 대한 입력과 출력을 하는 기능들이 있습니다.
 * 입력이 올바르지 않은 경우 예외처리를 하는 기능이 있습니다.
 *
 * @version 1.2.0            자동차 이름을 물어보는 기능 추가
 * @date 2019-12-05
 * @author HyungjuAn
 */
public class User {
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.\n"
		+ "(이름은 쉼표(,)를 기준으로 구분하며, 5자 이하만 가능합니다.)";

	public User() {
	}

	public ArrayList<Car> getCarsInformation() {
		ArrayList<Car> carList = new ArrayList<>();

		printCarNamesQuestion();
		// 사용자가 자동차들의 이름을 입력하는 기능

		return carList;
	}

	private void printCarNamesQuestion() {
		System.out.println(CAR_NAME_QUESTION);
	}

	@Override
	protected final void finalize() throws Throwable {
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
