package edu.woowa.course.racing.domain;

import edu.woowa.course.racing.utils.Utils;

/**
*@version 1.00 2019/04/03
*@author 조재훈
*/
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
    	this.name = name;
    }

    public void move() {
    	Utils.getRandomInt();
    }

}
