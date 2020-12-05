package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        CarValidator.validateCarName(name);
        this.name = name;
    }
    
    public void moveOrStop() {
        if (isMove()) {
            position++;
        }
    }
    
    private boolean isMove() {
        return (makeRandomNumber() >= 4);
    }

    private int makeRandomNumber() {
        return RandomUtils.nextInt(0, 9);
    }
}
