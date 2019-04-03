package xyz.zerobell;

/*
 * Car class
 *
 * ver 2.0
 *
 * 2019-04-04
 *
 * MIT License
 *
 * author : zerobell-lee
 *
 */

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static boolean isNameValid(String str) {
        return str.length() <= 5;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void boostOrStop() {
        int dice = (int)Math.floor(Math.random() * 10);

        if (dice >= 4) {
            this.position++;
        }
    }

    @Override
    public String toString() {
        String distance = "";
        for (int i = 0; i < this.position; i++) {
            distance += "-";
        }
        return String.format("%s : %s", this.name, distance);
    }
}
