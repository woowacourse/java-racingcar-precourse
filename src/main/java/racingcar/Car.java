package racingcar;

import utils.RandomUtils;

public class Car {
    private static final int TRY_NUMBER_MIN = 0;
    private static final int TRY_NUMBER_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryMove(){
        int rand = RandomUtils.nextInt(TRY_NUMBER_MIN, TRY_NUMBER_MAX);
        if(rand >= MOVE_CONDITION){
            position++;
        }
    }
}
