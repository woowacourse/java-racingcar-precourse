package domain;

public class Car {

    public static final int PROCEED_BASIS_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void proceedOrStop(int number) {
        if (isOverNumber(number)) {
            position++;
        }
    }

    private boolean isOverNumber(int number) {
        return number >= PROCEED_BASIS_NUMBER;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
