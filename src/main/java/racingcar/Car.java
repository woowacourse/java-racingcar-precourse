package racingcar;

import utils.RandomUtils;

public class Car {

    public static final int MIN_RANDOM_VALUE = 0;
    public static final int MAX_RANDOM_VALUE = 9;
    public static final int MIN_VALUE_FOR_ACCELERATE = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // nextInt 함수를 통해 불러온 인자가 MAX_VALUE_FOR_ACCELERATE 수치를 넘었는지 확인
    private boolean isAbleToAccelerate() {
        return RandomUtils.nextInt(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= MIN_VALUE_FOR_ACCELERATE;
    }

    // 가속 시도를 한 후 성공하면 포지션을 한 칸 이동시킴
    public void accelerate() {
        if (isAbleToAccelerate()) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
