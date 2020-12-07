package racingcar;

import utils.RandomUtils;

public class Car {
    public static final int NAME_MIN_LENGTH = 1;
    public static final int NAME_MAX_LENGTH = 5;
    public static final int POSITION_START = 0;
    private static final int MOVE_FORWARD_RANDOM_MIN = 0;
    private static final int MOVE_FORWARD_RANDOM_MAX = 9;
    private static final int MOVE_FORWARD_MIN_CONDITION = 4;
    
    private final String name;
    private int position = POSITION_START;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void tryMoveForward() {
        int randomNumber = RandomUtils.nextInt(MOVE_FORWARD_RANDOM_MIN, MOVE_FORWARD_RANDOM_MAX);
        
        if (randomNumber >= MOVE_FORWARD_MIN_CONDITION) {
            this.position++;
        }
    }
}
