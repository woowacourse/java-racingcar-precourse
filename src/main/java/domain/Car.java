package domain;

import java.util.Random;

/**
 * 자동차의 상태와 행위를 가지고 있는 class
 *
 * @author 송윤재
 * @version 1.0
 */
public class Car {
    private final String name;
    private int position = 0;

    private final static int STANDARD_GO = 3;
    private final static int BOUNDARY = 0;

    public Car(String name) {
        this.name = name;
    }

    public void updatePosition() {
        int randomNum = generateRandom();

        if (randomNum > STANDARD_GO) {
            position++;
        }
    }

    private int generateRandom() {
        return new Random().nextInt(BOUNDARY);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
