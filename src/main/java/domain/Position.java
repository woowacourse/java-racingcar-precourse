package domain;

public class Position {
    private static final int MOVING_UNIT = 1;
    private int position = 0;

    public void movePosition() {
        this.position += MOVING_UNIT;
    }

    public int getPosition() {
        return position;
    }
}
