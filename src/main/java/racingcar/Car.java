package racingcar;

import utils.RandomUtils;

public class Car {

    private final static String PROGRESS_BAR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int random = RandomUtils.nextInt(0, 9);
        if (random > 3) {
            position++;
        }
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(PROGRESS_BAR);
        }
        System.out.println();
    }
}
