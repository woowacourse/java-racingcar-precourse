package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;
    private static final int LOWER_BOUNDARY = 4;
    private static final int UPPER_BOUNDARY = 9;
    private static final String CAR_COUNTER = "-";


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

    public void calculatePosition() {
        boolean go = goOrNot();
        if (go) {
            this.position++;
        }
    }

    public void gameResult() {
        String ing = "";
        this.calculatePosition();

        for (int i = 0; i < this.getPosition(); i++) {
            ing = ing.concat(CAR_COUNTER);
        }
        System.out.println(this.getName() + " : " + ing);
    }
}
