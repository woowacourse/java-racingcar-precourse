package domain;

import java.util.Random;

class Car {
    private final String name;
    private int position = 0;
    private Random random = new Random();

    Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    String getName() {
        return this.name;
    }

    int getPosition() {
        return this.position;
    }

    void move() {
        isMove(random.nextInt(10));
        String positionStr = positionToString();
        System.out.println(this.name + ":" + positionStr);
    }

    private void isMove(int number) {
        if (number >= 4) {
            this.position++;
        }
    }

    private String positionToString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
