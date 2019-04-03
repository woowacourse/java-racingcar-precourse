package edu.woowa.course.racing.domain;

import edu.woowa.course.racing.utils.Utils;

/**
*@version 1.00 2019/04/03
*@author 조재훈
*/
public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;

    public Car(String name) {
    	this.name = name;
    }

    public void move() {
    	if ( Utils.isMove() ) {
    		position++;
    	}
    }

    public String getName() {
    	return this.name;
    }

    public int getPosition() {
    	return this.position;
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name);
		sb.append(":");
		for (int i =0; i < position; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	@Override
	public int compareTo(Car o) {
		return o.getPosition() - position;
	}
}
