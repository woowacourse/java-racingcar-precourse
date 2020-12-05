package racingcar.domain;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Position move() {
        return new Position(position + 1);
    }
}
