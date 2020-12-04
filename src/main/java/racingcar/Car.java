package racingcar;

public class Car {
    private final String name;
    private int position = 0;
    private StringBuilder positionLine = new StringBuilder();

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        this.position++;
        this.positionLine.append("-");
    }

    public String getName() {
        return this.name;
    }

    public String getPositionLine() {
        return positionLine.toString();
    }

    public int getPosition() {
        return this.position;
    }
}
