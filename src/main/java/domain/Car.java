package domain;

import java.util.Random;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void useTurn() {
        boolean move = decideMove();
        if (move) position += 1;
        showCurrentPosition();
    }

    private boolean decideMove() {
        Random random = new Random(System.currentTimeMillis());
        int number = random.nextInt(10);
        return number >= 4;
    }

    private void showCurrentPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
