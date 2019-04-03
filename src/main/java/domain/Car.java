/*
 * @Car.java        1.03 2019/04/03
 * 
 * Copyright(c)2019 HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 2주차 미션 ]
 * 자동차 경주 프로그램
 */

package domain;

/**
 * 자동차의 정보를 가지고 있는 클래스
 * 자동차에 대한 데이터 포맷을 정의하기 위해 사용되는 클래스이다.
 * 자동차의 이름,현재 위치에 대한 정보를 가지고 있는 객체이다.
 * 
 * @version 1.03 2019년 4월 3일
 * @author 홍휘진
 */
public class Car {

    private static final int MIN_POSITION = 0;
    
    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        if (name == null) {
            return "No Data in Car";
        }

        StringBuilder car = new StringBuilder();
        car.append(name).append(" : ");
        for (int i = MIN_POSITION; i < position; i++) {
            car.append('-');
        }
        return car.toString();
    }
}
