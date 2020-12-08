package racingcar;

import utils.RandomUtils;

public class Car {

    private static final String PROGRESS_BAR = "-";

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
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

    public String nominateCar(int max, String winners) {
        if (max == position) {
            return winners.concat(", " + name);
        }
        return name;
    }
}
