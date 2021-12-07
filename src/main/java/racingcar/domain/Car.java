package racingcar.domain;

public class Car implements Raceable {

    private static final int MIN_MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public boolean isMovable(int number) {
        return number >= MIN_MOVE_CONDITION;
    }

    @Override
    public void moveForward() {
        position++;
    }

    @Override
    public <T extends Raceable> boolean isSamePositionWith(T competitor) {
        return position == competitor.getPosition();
    }

    @Override
    public int compareTo(Raceable other) {
        return position - other.getPosition();
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
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
