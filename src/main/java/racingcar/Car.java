package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int BENCHMARK = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int randomNum = RandomUtils.nextInt(RANDOM_MIN, RANDOM_MAX); //0~9의 랜덤
        if (randomNum >= BENCHMARK) {
            this.position += 1;
        }
    }

    public boolean isMaxPosition(int maxDistance){
        return this.getPosition() == maxDistance;
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}