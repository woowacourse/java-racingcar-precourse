package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;
    private static final int MOVE_BOUND = 3;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int random) {
        if (isMoving(random)) {
            position++;
        }
        result();
    }

    private boolean isMoving(int random) {
        return random > MOVE_BOUND;
    }

    public void result() {
        System.out.print(name + ":");
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
