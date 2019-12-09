/*
 * @(#)Car.java        2019/12/10
 *
 *
 */

package domain;

/**
 * 자동차 정보 저장을 위한 Car 클래스
 *
 * @version		0.1 2019년 12월 10일
 * @author		YerinCho          
 */

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}
	
	public void isGoStop(int n) {
	    if(n>=4) {
		this.position+=1;
	    }
	}

	public int getPosition() {
	    return this.position;
	}
	
	public String getName() {
	    return this.name;
	}
}