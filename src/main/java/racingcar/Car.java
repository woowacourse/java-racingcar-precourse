package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int START = 0;
    private static final int END = 9;
    private static final String moveCharacter = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove() {
        if (RandomUtils.nextInt(START, END) >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(moveCharacter);
        }
        return this.name + " : " + sb;
    }

    // 추가 기능 구현
}
