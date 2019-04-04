/*
 * Car.java		2019/04/04
 * 
 * 이 프로그램은 누구나 수정 가능합니다.
 */

package domain;

import java.util.Random;
import java.lang.StringBuilder;

/**
 * 레이싱 게임을 수행하는 Car 클래스이다.
 * 
 * @version 1.00 2019/04/04
 * @author DiceMono
 */
public class Car {

	private final String name;
	private int position = 0;
	private Random random = new Random();
	private StringBuilder stringPosition = new StringBuilder();

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getPosition() {
		return this.position;
	}

	public void tryMove() {
		int randomInt = random.nextInt(10);

		if (randomInt >= 4) {
			position++;
			stringPosition.append('-');
		}
	}

	public void printPosition() {
		System.out.println(this.name + " : " + stringPosition);
	}

	/* 테스트 코드 */
	public static void main(String[] args) {
		Car pobi = new Car("pobi");
		Car crong = new Car("crong");

		for (int count = 0; count < 10; count++) {
			pobi.tryMove();
			pobi.printPosition();
			crong.tryMove();
			crong.printPosition();
			System.out.println();
		}
	}
}
