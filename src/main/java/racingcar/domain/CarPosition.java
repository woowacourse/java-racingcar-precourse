package racingcar.domain;

public class CarPosition {
    private int position = 0;

    public void moveForward() {
        position ++;
    }

    public int position() {
        return this.position;
    }
}
