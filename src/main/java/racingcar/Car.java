package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goOrStop(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getCurrentPosition() {
        StringBuilder carPosition = new StringBuilder(name);
        carPosition.append(" : ");
        for (int i = 0; i < position; i++) {
            carPosition.append("-");
        }
        return carPosition.toString();
    }
}
