package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private static final int LOWER_BOUNDARY = 4;
    private static final int UPPER_BOUNDARY = 9;


    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 랜덤값에 따라 동작 여부 확인
    public boolean goOrNot() {
        Random rand = new Random();
        int randomGo;

        randomGo = rand.nextInt(UPPER_BOUNDARY + 1);
        if (randomGo >= LOWER_BOUNDARY) {
            return true;
        }
        return false;
    }


}
