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

    public String currentStatus() {
        StringBuilder status = new StringBuilder();

        status.append(name);
        status.append(":");

        for (int i = 0; i < position; i++) {
            status.append("-");
        }

        return status.toString();
    }

    public int getPosition() {
        return position;
    }
}
