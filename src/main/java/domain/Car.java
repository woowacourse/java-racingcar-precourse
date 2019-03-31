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
        Random random = new Random();
        return random.nextInt(10);
    }

    private void moveCheak(int num) {
        if (num >= 4) {
            this.position++;
        }
    }
}
