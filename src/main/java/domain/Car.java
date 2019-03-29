/*
 * @Car.java    0.1 2019/03/29
 */

package domain;

/**
 * 자동차의 이름과 위치를 갖는 클래스
 *
 * @author 이도원
 * @version 0.1 2019/03/29
 */
public class Car {
    private static final int SPEED = 1;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    /* 자동차를 전진시키는 메소드 */
    public void move() {

        /* 자동차는 한번 움직일 때 SPEED 값 만큼 전진한다 */
        position += SPEED;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
