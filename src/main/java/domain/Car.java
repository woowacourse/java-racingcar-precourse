package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    private int getRandomNumber() {
        Random rd = new Random();

        return rd.nextInt(10);
    }

    private boolean isGo(int number) {
        return number >= 4;
    }

    public void goRace() {
        int randNumber = getRandomNumber();

        if (isGo(randNumber)) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.name;
    }

}
