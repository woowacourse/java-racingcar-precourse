/**
 * Car.class        1.0 2019/03/26
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */

package domain;

/**
 * Racing에서 자동차의 역할을 하는 클래스
 *
 * @version         1.0
 * @author          이남준
 */
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /**
     * random 넘버가 4이상일 경우 차량을 전진시키는 메소드
     * @param rndNum RacingManager에서 생성한 난수
     */
    public void moveCar(int rndNum) {
        if(rndNum >= 4) {
            position++;
        }
    }
}
