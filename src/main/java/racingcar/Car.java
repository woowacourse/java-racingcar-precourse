package racingcar;

import utils.RandomUtils;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }


    public void move() {
        moveOnRandomNum();
        printResult();
    }

    private void moveOnRandomNum() {
        int randomNum = RandomUtils.nextInt(0, 9);
        if (randomNum >= 4)
            this.position++;
    }

    private void printResult() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
