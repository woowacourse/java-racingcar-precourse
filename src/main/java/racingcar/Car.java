package racingcar;

import static utils.RandomUtils.nextInt;

public class Car {
    private final String name;
    private int position = 0;

    private int MIN_NUMBER = 0;
    private int MAX_NUMBER = 9;
    private String POSITION_MARK = "-";

    public Car(String name) {
        this.name = name;
    }

    public void moveCar(){
        if (nextInt(MIN_NUMBER,MAX_NUMBER) >= 4) {this.position += 1;}
    }

}
