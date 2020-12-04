package racingcar.type;

public enum BoundaryType {

    MINIMUM_MOVE_NUMBER(4),
    MAXIMUM_MOVE_NUMBER(9),
    MINIMUM_STOP_NUMBER(0),
    MAXIMUM_STOP_NUMBER(3);

    private final int boundary;

    BoundaryType(int boundary) {
        this.boundary = boundary;
    }

    public int getBoundary() {
        return boundary;
    }
}
