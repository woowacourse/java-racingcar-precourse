/**
 * @(#)Car.java
 * 0.0.0
 * 2019/12/10
 */

package domain;

/**
 * 개별 자동차의 이름과 위치정보를 저장, 출력, 제어하기 위한 클래스
 * 
 * @version 0.0.0 2019년 12월 10일
 * @author tiroring
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
	
	public int getPosition() {
		return this.position;
	}

	public void addPosition() {
		this.position += 1;
	}
}
