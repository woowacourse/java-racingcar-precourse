/*
 * @(#)Car.java     1.0 2019.12.09
 *
 * Copyright (c) 2019 lxxjn0.
 */

package domain;

import java.util.Random;

/**
 * Car 클래스
 *
 * @author JUNYOUNG LEE (lxxjn0)
 * @version 1.0 2019.12.09
 */
public class Car {
	/**
	 * 자동차의 전진 여부를 판단할 때 사용하는 상수.
	 */
	private static final int FORWARD_JUDGEMENT_NUMBER = 3;

	/**
	 * 생성 가능한 random 변수의 최대 범위를 제한하기 위한 상수.
	 */
	private static final int MAX_RANDOM_RANGE = 10;

	/**
	 * 자동차들의 위치 중에서 가장 먼 위치(Position)의 값을 저장하는 클래스 변수.
	 */
	private static int furthestPosition = 0;

	/**
	 * 자동차의 이름을 저장하는 String 변수.
	 */
	private final String name;

	/**
	 * 자동차의 위치를 저장하는 int 변수.
	 */
	private int position = 0;

	/**
	 * 자동차의 이름을 매개변수로 받는 Car 클래스의 매개변수 생성자.
	 *
	 * @param name 생성할 자동차의 이름.
	 */
	public Car(String name) {
		this.name = name;
	}

	/**
	 * 랜덤한 수에 따라 자동차를 이동시키고, 변경된 position이 모든 자동차들 중에서 가장 큰 값이면 furthestPosition을 초기화시키는 메소드.
	 */
	public void moveAndSetFurthestPosition() {
		if (isCarMoveForward()) {
			moveForward();
			setIfFurthestPosition();
		}
	}

	/**
	 * 자동차가 앞으로 이동하는지 여부를 판단하는 메소드.
	 *
	 * @return 랜덤하게 생성된 수가 3보다 크면 true 반환.
	 */
	private boolean isCarMoveForward() {
		return (generateRandomNumber() > FORWARD_JUDGEMENT_NUMBER);
	}

	/**
	 * 0부터 9까지의 범위 내의 정수를 랜덤하게 생성해서 반환해주는 메소드.
	 *
	 * @return 0부터 9까지의 범위 내의 랜덤하게 생성된 정수를 반환.
	 */
	private int generateRandomNumber() {
		return new Random().nextInt(MAX_RANDOM_RANGE);
	}

	/**
	 * 자동차를 앞으로 이동시키는 메소드.
	 */
	private void moveForward() {
		position++;
	}

	/**
	 * 전진한 위치가 모든 자동차들 중 가장 큰 값이면 해당 위치로 furthestPosition을 초기화시키는 메소드.
	 */
	private void setIfFurthestPosition() {
		if (position > furthestPosition) {
			furthestPosition = position;
		}
	}

	/**
	 * name getter
	 *
	 * @return 자동차의 이름을 반환.
	 */
	public String getName() {
		return name;
	}

	/**
	 * position getter
	 *
	 * @return 자동차의 현재 위치를 반환.
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * furthestPosition getter
	 *
	 * @return 모든 자동차들 중에서 가장 멀리 위치한 position의 값을 반환.
	 */
	public static int getFurthestPosition() {
		return furthestPosition;
	}
}
