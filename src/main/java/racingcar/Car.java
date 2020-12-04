package racingcar;

import utils.RandomUtils;

public class Car {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int getMovePoint() {
        int randomNumber = RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
        if (randomNumber > 4) {
            return 1;
        }
        return 0;
    }

    public void carMove() {

    }

    public void printCarState() {

    }

}
