package racingcar;

import utils.RandomUtils;

public class Car {
    private static final String WRITE_LESS_FIVE_LENGTH_NAME = "[ERROR] 5자 이하의 이름을 입력하세요.";
    private static final int STANDARD_NAME_LENGTH = 5;
    private static final int STANDARD_NUMBER = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        isLessFiveName(name);
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void isLessFiveName(String name) {
        if (name.length() > STANDARD_NAME_LENGTH) {
            throw new IllegalArgumentException(WRITE_LESS_FIVE_LENGTH_NAME);
        }
    }

    public void goOrStop(int randomNumber) {
        if (randomNumber >= STANDARD_NUMBER) {
            this.position++;
        }
    }

    public boolean isMax(int max) {
        return this.getPosition() == max;
    }
}
