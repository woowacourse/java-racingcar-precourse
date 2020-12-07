package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int START_VALUE = 0;
    private static final int END_VALUE = 9;
    private static final int MIN_LENGTH = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryingMove() {
        int distance = randomDistance();
        if(isPossiblyMoving(distance)) {
            this.position += distance;
        }
    }

    public int getScore() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public boolean beat(Car opponent) {
        return this.getScore() > opponent.getScore();
    }

    private int randomDistance() {
        return RandomUtils.nextInt(START_VALUE, END_VALUE);
    }

    private boolean isPossiblyMoving(int distance) {
        return distance >= MIN_LENGTH;
    }
}
