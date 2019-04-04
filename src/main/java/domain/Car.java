/*
 * 	@(#)Car.java    ver1.0.0    04/04/2019
 *  우아한 테크코스 2주차 미션 - 자동차 경주 게임
 */
package domain;

import java.util.Random;

/**
 * Car: 자동차 생성 및 위치에 대한 정보를 갖고있는 클래스이다.
 *
 * @author            김선관
 * @version           ver1.0.0
 */
public class Car {
    private final String name;
    private int position = 0;

    /**
     * ZERO_2_NINE: 0 ~ 9 사이의 무작위 수를 뽑기 위해 선언한 상수
     * GO_THRESHOLD: 자동차가 전진하기 위해 필요한 최소 문턱 수
     */
    static final int ZERO_2_NINE = 10;
    static final int GO_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
    }

    /**
     * goStop: 자동차가 전진하거나 멈춰있는 기능을 구현한 메소드
     */
    public void goStop() {
        Random random = new Random();
        if (random.nextInt(ZERO_2_NINE) >= GO_THRESHOLD) {
            position++;
        }
    }

    public int getPos () {
        return this.position;
    }
}
