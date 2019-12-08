package domain;

/**
 * ClassName : Car
 * ClassExplanation : 플레이어(자동차) 속성 및 기능
 * author : Kim SeYun
 * Date : 2019. 12. 08
 * Copyright (c) 2019 SeYun Kim
 */
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
        position++;
    }

    public String currentMove() {
        StringBuffer currentPosition = new StringBuffer();
        for (int i = 0; i < this.position; i++) {
            currentPosition.append("-");
        }
        return currentPosition.toString();
    }
}
