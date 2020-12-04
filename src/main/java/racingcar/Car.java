package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        this.position++;
    }

    public String getName() {
        return this.name;
    }

    public String getPositionLine() {
        StringBuilder positionLine = new StringBuilder();

        for (int i = 0; i < this.position; i++) {
            positionLine.append("-");
        }

        return positionLine.toString();
    }

    public int getPosition() {
        return this.position;
    }
}
