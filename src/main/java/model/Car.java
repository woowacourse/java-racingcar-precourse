package model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar() {
        int ranNum = Randoms.pickNumberInRange(0, 9);
        
        if(ranNum >= 4) {
            position += 1;
        }
    }
}
