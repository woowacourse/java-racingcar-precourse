package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void tryToMove(int roundNumber) {
        if (MovementArbiter.canMove()) {
            position++;
        }
        Round.registerCarMovement(roundNumber, name, position);
    }
}
