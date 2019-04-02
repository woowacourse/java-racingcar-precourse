/*
 * @Car.java   1.0 2019/04/02
 */

package domain;

/**
 * 자동차 클래스
 *
 * @version 1.00 2019년 4월 2일
 * @author 최훈하
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String toString() {
        return name;
    }

    /* 전진 */
    public int Forward(){
        if (Forward_Util.random_Number_Create() > 3) {
            position+=1;
            return position;
        }
        return position;
    }



}
