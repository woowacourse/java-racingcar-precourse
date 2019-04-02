/*
 * @(#)Main.java        0.4 2019/04/02
 *
 *
 */

package domain;

import java.util.Random;

/**
 * Car 객체 생성을 위한 클래스입니다.
 *
 * @author 반선호
 * @version 0.4 2019년 4월 02일
 */

public class Car implements Comparable<Car> {
    private static final int MAXIMUM_RANDOM_VALUE = 10;
    private static final int MOVE_DECISION_VALUE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void runOneCycle() {
        int distance = createRandomDistance();
        if (lagerThanFour(distance)) {
            movePosition();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private int createRandomDistance() {
        Random random = new Random();
        return random.nextInt(MAXIMUM_RANDOM_VALUE);
    }

    private boolean lagerThanFour(int distance) {
        return (distance >= MOVE_DECISION_VALUE);
    }

    private void movePosition() {
        position++;
    }

    @Override
    public int compareTo(Car car) {
        return car.getPosition() - position;
    }
}
