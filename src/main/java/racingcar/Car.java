package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        if (3 < RandomUtils.nextInt(0, 9)) {
            position++;
        }
        printCarPosition();
    }

    private void printCarPosition() {
        StringBuilder moveDistance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            moveDistance.append("-");
        }
        System.out.println(name + " : " + moveDistance);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
