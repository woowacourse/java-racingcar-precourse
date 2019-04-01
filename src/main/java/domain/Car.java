/*
 * @Car.java		1.00 2019/04/01
 * 
 * Copyright(c)2019	HwiJin Hong.
 * All right reserved.
 * 
 * 자동차 경주 프로그램
 * 자동차에 대한 데이터 포맷을 정의하기 위해 사용되는 클래스이다.
 * 자동차의 이름,현재 위치에 대한 정보를 가지고 있는 객체이다.
 */

package domain;

/**
 * 자동차의 정보를 가지고 있는 클래스
 * 
 * @version 1.00 2019년 4월 1일
 * @author huisam
 */
public class Car {
	
    private final String name;
    
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

}
