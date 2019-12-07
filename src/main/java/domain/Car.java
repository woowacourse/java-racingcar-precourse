package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String progress = positionToString();

        stringBuilder.append(name);
        stringBuilder.append(':');
        stringBuilder.append(progress);
        return stringBuilder.toString();
    }

    private String positionToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append('-');
        }

        return stringBuilder.toString();
    }

    public void updateOneCycle() {
        if (decideGoOrNot()) {
            position++;
        }
    }

    private boolean decideGoOrNot() {
        int num = drawRandomNumber();
        if (num >= 4) {
            return true;
        }
        return false;
    }

    private int drawRandomNumber() {
       return (int)(Math.random() * 10);
    }
}
