/*
 * Class	: Car
 * 
 * Version	: 1.0.0
 * 
 * Date		: 2019-04-03
 * 
 * Copyright: Jeongho Park
 */

package domain;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void addPosition() {
		this.position++;
	}

	public int getPosition() {
		return this.position;
	}

}
