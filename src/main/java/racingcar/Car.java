package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
        int randomNumber = getRandomNumber();
        if (randomNumber > 3) {
            position++;
        }
        result();
    }

    public int getRandomNumber() {
        return RandomUtils.nextInt(LOWER_BOUND, UPPER_BOUND);
    }

    public void result() {
        System.out.print(name + ":");
        for (int i = 0; i < position; i++) {
            System.out.print('-');
        }
        System.out.println();
    }
}
