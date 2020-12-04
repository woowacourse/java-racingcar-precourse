package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int RANGE_MINIMUM = 0;
    private static final int RANGE_MAXIMUM = 9;
    private static final int GO_MINIMUM = 4;
    
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goOrStop() {
        int rand = RandomUtils.nextInt(RANGE_MINIMUM, RANGE_MAXIMUM);
        if (rand >= GO_MINIMUM) {
            position++;
        }
    }
    
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
}
