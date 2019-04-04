/*
 * @(#)Car.java		2019/4/4
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Car 클래스는 자동차의 이름과 위치를 갱신하고 반환하는 기능을 합니다.
 * 
 * @version			1.00 2019년 4월 4일
 * @author 			한준모
 */

package domain;

public class Car {
		
	    private final String name;
	    private int position = 0;
	
	    public Car(String name) {
	        	this.name = name;
	    }
	
	    // 추가 기능 구현
	    public int updatePositionOfCar() {
	    		return (Validation.isValidMovingCondition() ? moveForward() : position);
	    }
	    
	    public int moveForward() {
	    		return ++position;
	    }
	    
	    public String getName() {
	    		return name;
	    }
	    
	    public int getPosition() {
	    		
	    }
}