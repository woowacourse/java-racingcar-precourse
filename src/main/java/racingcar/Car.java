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

    public void run(){
        if(generateRandomNumber()) {
            position++;
        }
        System.out.println(getName() + " : " +getPosition());
    }

    public String getPosition(){
        String carPosition = "";
        for(int i =0; i<position; i++){
            carPosition += "-";
        }
        return carPosition;
    }

    private boolean generateRandomNumber(){
        return RandomUtils.nextInt(0,9) >= 4;
    }
}
