/*
 *  클래스 이름 : Car.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-03-29
 *
 *  저작권 : 이예지
 */

package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void moveCar() {
		this.position++;
	}


}
