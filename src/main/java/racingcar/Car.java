package racingcar;

public class Car {

    private final String name;
    private static int winningPosition = 0;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        if (RacingCarMovement.moveCar()) {
            this.position += 1;
            calculateWinner(this.position);
        }
    }

    public static void calculateWinner(int position) {
        if (position > winningPosition) {
            winningPosition = position;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getCarPosition() {
        return position;
    }

    public static int getWinningPosition() {
        return winningPosition;
    }
}
