package domain;

import utils.RandomGenerate;

public class Car {
    private final String name;
    private int position = 0;

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
        int num = RandomGenerate.pickNum();
        if(num > 4){
            position++;
        }
    }
}
