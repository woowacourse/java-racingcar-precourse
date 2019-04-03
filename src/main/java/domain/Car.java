package domain;

import java.util.Random;

public class Car implements Comparable<Car> {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void increasePosition(int randomNum) {
        if (randomNum >= 4)
            position += 1;
    }

    public int makeRandomNums() {
        Random rand = new Random();
        int randomNums = rand.nextInt(10);
        return randomNums;
    }

    /*Car 객체 내 position을 하기 위하여 구현한 메소드*/
    public int compareTo(Car car) {
        if (this.position > car.position) {
            return -1;
        }
        return 1;
    }
}