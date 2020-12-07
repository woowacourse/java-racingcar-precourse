package racingcar;

import utils.RandomUtils;

public class Car {
    public static final int INT_RANDOM_LOWER_BOUND = 0;
    public static final int INT_RANDOM_UPPER_BOUND = 9;
    public static final int INT_MOVE_CRITERIA = 4;
    public static final String DELIMITER_BETWEEN_NAME_AND_PROGRESS_MARK = " : ";
    public static final String PROGRESS_MARK = "-";
    public static final String NEXT_LINE = "\n";
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move() {
        int random = RandomUtils.nextInt(INT_RANDOM_LOWER_BOUND, INT_RANDOM_UPPER_BOUND);
        if (random >= INT_MOVE_CRITERIA) {
            position++;
        }
    }

    public void printPosition() {
        System.out.print(name + DELIMITER_BETWEEN_NAME_AND_PROGRESS_MARK);
        for (int i = 0; i < position; i++) {
            System.out.print(PROGRESS_MARK);
        }
        System.out.print(NEXT_LINE);
    }

    public String getName () {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
