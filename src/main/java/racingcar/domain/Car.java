package racingcar.domain;

import static racingcar.util.RandomUtil.checkMoveOrWait;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void progress() {
        if(checkMoveOrWait()) {
            move();
        }
    }

    public void printProgress() {
        String result = "";

        for (int i = 0; i < this.position; i++) {
            result.concat("-");
        }

        System.out.println(this.name + " : " + result);
    }

    private void move() {
        this.position ++;
    }
}
