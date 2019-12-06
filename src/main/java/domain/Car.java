package domain;

import domain.*;

public class Car {
    private final String name;
    private int position = 0;
    RandomMakeNum makeNum = new RandomMakeNum();

    public Car(String name) {
        this.name = name;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public void forwordPosition(){
        if(makeNum.randomMakeNum()) {
            this.position++;
        }
    }
}
