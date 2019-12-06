/*
 * User.java                       1.4.0   2019-12-06
 *
 * Copyright (c) 2019 Hyungju An.
 * All rights reserved.
 * Contact me for more information. a301dks@naver.com
 */

package com.precourse.racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * User 클래스입니다.
 * 사용자에 대한 입력과 출력을 하는 기능들이 있습니다.
 * 입력이 올바르지 않은 경우 예외처리를 하는 기능이 있습니다.
 *
 * @version 1.4.0            자동차 이름 입력이 올바른지 확인하는 기능 추가
 * @date 2019-12-06
 * @author HyungjuAn
 */
public class User {
	private static final int MINIMUM_CARS = 2;
	private static final int SPLIT_LIMIT = -1;
	private static final String COMMA = ",";
	private static final String CAR_NAME_QUESTION = "경주할 자동차 이름을 입력하세요.\n"
		+ "(이름은 쉼표(,)를 기준으로 구분하며, 5자 이하만 가능합니다.)";

	public User() {
	}

	public ArrayList<Car> getCarsInformation() throws IOException {
		ArrayList<Car> carList = new ArrayList<>();

		printCarNamesQuestion();
		readCarNames(carList);

		return carList;
	}

	private void printCarNamesQuestion() {
		System.out.println(CAR_NAME_QUESTION);
	}

	private void readCarNames(ArrayList<Car> carList) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		if (!isRightCarNames(input)) {
			readCarNames(carList);
			return;
		}

		StringTokenizer tokenizer = new StringTokenizer(input, COMMA);
		while (tokenizer.hasMoreTokens()) {
			carList.add(new Car(tokenizer.nextToken()));
		}
	}

	private boolean isRightCarNames(String input) {
		boolean result = true;
		String[] carNames = input.split(COMMA, SPLIT_LIMIT);

		for (int i = 0; i < carNames.length; i++) {
			if (carNames[i].isEmpty()) { // || 각 차 이름이 5자 이하인지 확인하는 기능
				result = false;
				break;
			}
		}
		if (carNames.length < MINIMUM_CARS) {
			result = false;
		}

		return result;
	}

	@Override
	protected final void finalize() throws Throwable {
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
