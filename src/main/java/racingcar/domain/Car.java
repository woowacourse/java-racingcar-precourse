package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean attemptMove(int number) {
        if (isMovable(number)) {
            position++;
            return true;
        }
        return false;
    }

    private boolean isMovable(int number) {
        return number >= 4;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePositionWith(Car other) {
        return position == other.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return position - other.position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
