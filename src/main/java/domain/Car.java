package domain;

import java.util.Random;

class Car {
    private static int headPosition = 0;

    private final String name;
    private int position = 0;

    Car(String name) {
        this.name = name;
    }

    void useTurn() {
        boolean move = decideMove();
        if (move) position += 1;
        showCurrentPosition();
        updateHeadPosition();
    }

    boolean isHead(){
        return headPosition == this.position;
    }

    String getName(){
        return name;
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

    private void updateHeadPosition() {
        if (this.position > headPosition) headPosition = this.position;
    }
}
