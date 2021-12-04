package domain;

import utils.RandomGenerate;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private RandomGenerate randomGenerate = new RandomGenerate();

    public Car(String name) {
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void goOrStop(){
        int num = randomGenerate.pickNum();
        if(num > 3){
            position++;
        }
    }
}
