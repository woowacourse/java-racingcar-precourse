package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPosition(){
        return position;
    }

    public void run(){
        if(generateRandomNumber()) {
            position++;
        }
    }

    private boolean generateRandomNumber(){
        return RandomUtils.nextInt(0,9) >= 4;
    }
}
