package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    private final String MARK = "-";

    public Car(String name) {
        this.name = name;
    }

    public int generateRandomValue() {

        return 0;
    }

    public void updatePosition() {

    }

    private String indicatePosition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int count = 0; count < position; count++) {
            stringBuilder.append(MARK);
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return name + " : " + indicatePosition();
    }
}
