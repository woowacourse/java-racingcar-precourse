package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void play() {
        Random rand = new Random();
        int number = rand.nextInt(10);

        if (number >= 4) {
            this.position++;
        }
    }
}
