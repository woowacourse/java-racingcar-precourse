package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryToMoveForward(){
        int randomNum = RandomUtils.nextInt(0, 9);
        if(randomNum > 3){
            position++;
        }
    }
}
