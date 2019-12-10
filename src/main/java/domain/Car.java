/*
 * @(#)Car.java
 *
 * 버전 : 1.0
 *
 * 날짜 : 2019.12.10
 */
package domain;

/**
 * 우아한테크코스 프리코스 2주차 자동차 경주 게임
 * 설명 : 자동차 객체를 표현할 Car 클래스
 *
 * @version 1.0     2019.12.10
 * @author 최재우
 */
public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void goCar() {
		position += 1;
	}

	public int getPosition() {
		return position;
	}
}
