/*
 * @(#) Car.java     1.0   2019/04/02
 *
 * Released under the MIT license
 */

package domain;

import java.util.Random;

/**
 * Car 클래스는 자동차경주에 참여하는 자동차다.
 *
 * @version  1.00  2019년 04월 02일
 * @author   조남균
 */
public class Car {
	private static final int RANDOM_BOUND = 10;
	private static final int MOVE_BOUND = 4;
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void tryMove() {
		if (checkMove()) {
			position++;
		}
	}

	private boolean checkMove() {
		Random random = new Random();
		int randomNum = random.nextInt(RANDOM_BOUND);
		if (randomNum >= MOVE_BOUND) {
			return true;
		}
		return false;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}
}